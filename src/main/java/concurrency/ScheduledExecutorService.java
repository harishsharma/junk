package concurrency;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ScheduledExecutorService {

    private static final int ONCE = 1;
    private static final int FIXED_RATE = 2;
    private static final int FIXED_DELAY = 3;
    private final Lock lock;
    private final Condition taskAdded;
    private final Queue<ScheduledTask> queue = new PriorityQueue<>();
    private final ExecutorService executorService;

    public ScheduledExecutorService() {
        this.lock = new ReentrantLock();
        this.taskAdded = lock.newCondition();
        this.executorService = Executors.newFixedThreadPool(4);
        start();
    }

    private void start() {
        while (true) {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    try {
                        taskAdded.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                while (!queue.isEmpty()) {
                    ScheduledTask top = queue.peek();
                    long timeToSleep = top.scheduledTime - System.currentTimeMillis();
                    if (timeToSleep <= 0) {
                        break;
                    }
                    try {
                        taskAdded.await(timeToSleep, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                ScheduledTask top = queue.poll();
                switch (top.taskType) {
                    case ONCE:
                        executorService.submit(top.command);
                        break;
                    case FIXED_DELAY:
                        CompletableFuture.runAsync(() -> {
                            top.command.run();
                            long scheduledTime = System.currentTimeMillis() + top.timeUnit.toMillis(top.delay);
                            top.scheduledTime = scheduledTime;
                            queue.add(top);
                            taskAdded.signalAll();
                        }, executorService);
                        break;
                    case FIXED_RATE:
                        long scheduledTime = System.currentTimeMillis() + top.timeUnit.toMillis(top.period);
                        top.scheduledTime = scheduledTime;
                        queue.add(top);
                        taskAdded.signalAll();
                        break;
                    default:
                        throw new IllegalStateException();
                }


            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * Creates and executes a one-shot action that becomes enabled after the given delay.
     */
    public void schedule(Runnable command, long delay, TimeUnit unit) {
        lock.lock();
        try {
            long scheduledTime = System.currentTimeMillis() + unit.toMillis(delay);
            ScheduledTask task = new ScheduledTask(command, scheduledTime, null, null, ONCE, unit);
            queue.add(task);
            taskAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given period; that is executions will commence after initialDelay then
     * initialDelay+period, then initialDelay + 2 * period, and so on.
     */
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        lock.lock();
        try {
            long scheduledTime = System.currentTimeMillis() + unit.toMillis(initialDelay);
            ScheduledTask task = new ScheduledTask(command, scheduledTime, period, null, FIXED_RATE, unit);
            queue.add(task);
            taskAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /*
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given delay between the termination of one execution and the commencement of the next.
     */
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        lock.lock();
        try {
            long scheduledTime = System.currentTimeMillis() + unit.toMillis(initialDelay);
            ScheduledTask task = new ScheduledTask(command, scheduledTime, null, delay, FIXED_RATE, unit);
            queue.add(task);
            taskAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    class ScheduledTask implements Comparable<ScheduledTask> {
        private Runnable command;
        private long scheduledTime;
        private Long period;
        private Long delay;
        private int taskType;
        private TimeUnit timeUnit;

        public ScheduledTask(Runnable command, long scheduledTime, Long period, Long delay, int taskType, TimeUnit timeUnit) {
            this.command = command;
            this.scheduledTime = scheduledTime;
            this.period = period;
            this.delay = delay;
            this.taskType = taskType;
            this.timeUnit = timeUnit;
        }

        @Override
        public int compareTo(ScheduledTask other) {
            return Long.compare(this.scheduledTime, other.scheduledTime);
        }
    }

    enum TaskType {
        ONCE, FIXED_DELAY, FIXED_RATE
    }
}
