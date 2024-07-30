package concurrency;

import java.util.Comparator;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DelayScheduler {

    private final DelayQueue<DelayTask> taskQueue;

    public DelayScheduler() {
        this.taskQueue = new DelayQueue<>();
        startExecute();
    }

    public void scheduler(Runnable task, long delayTime) {
        taskQueue.add(new DelayTask(System.currentTimeMillis() + delayTime, task));
    }

    private void startExecute() {
        Runnable execute = () -> {
            while (true) {
                try {
                    DelayTask task = this.taskQueue.take();
                    task.task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(execute, "Executor").start();
    }

    class DelayTask implements Delayed{

        private final long startTime;
        private final Runnable task;

        public DelayTask(long startTime, Runnable task) {
            this.startTime = startTime;
            this.task = task;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = startTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
        }
    }
}
