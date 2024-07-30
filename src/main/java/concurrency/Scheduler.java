package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {

    private int pendingTasks = 0;
    private final ExecutorService executorService;

    public Scheduler() {
        this.executorService = Executors.newFixedThreadPool(2);
    }

    public void schedule(Callable<?> callable) {
        executorService.submit(() -> {
            try {
                callable.call();
                synchronized (this) {
                    pendingTasks--;
                    notifyAll();
                }
            } catch (java.lang.Exception e) {
                throw new RuntimeException(e);
            }
        });
        pendingTasks++;
    }

    public void waitUntilComplete() {
        synchronized (this) {
            while (pendingTasks > 0) {
                try {
                    System.out.println("Pending tasks currently " + pendingTasks + " in thread " + Thread.currentThread().getName());
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scheduler scheduler = new Scheduler();
        scheduler.schedule(() -> {
            System.out.println("Calling in thread " + Thread.currentThread().getName());
            Thread.sleep(10000);
            return 1;
        });

        scheduler.schedule(() -> {
            System.out.println("Calling in thread " + Thread.currentThread().getName());
            Thread.sleep(10000);
            return 1;
        });

        scheduler.schedule(() -> {
            System.out.println("Calling in thread " + Thread.currentThread().getName());
            Thread.sleep(10000);
            return 1;
        });

        scheduler.waitUntilComplete();
        System.out.println("Main exit.");
    }
}
