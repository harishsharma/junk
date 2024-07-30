package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyExecutor {
    private final int threadPoolSize;
    private final Queue<Worker> workers;
    private final java.util.concurrent.BlockingQueue<Runnable> workQueue;

    public MyExecutor(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
        this.workQueue = new LinkedBlockingQueue<>();
        this.workers = new LinkedList<>();
        for (int i = 0; i < threadPoolSize; i++) {
            Worker worker = new Worker(workQueue);
            workers.add(worker);
            worker.workThread.start();
        }
    }

    public void execute(Runnable task) {
        workQueue.add(task);
    }

    class Worker implements Runnable {
        private final java.util.concurrent.BlockingQueue<Runnable> workQueue;
        private volatile boolean shutdown = false;
        private final Thread workThread;

        public Worker(BlockingQueue<Runnable> workQueue) {
            this.workQueue = workQueue;
            workThread = new Thread(this);
        }

        public void shutDown() {
            shutdown = true;
        }

        @Override
        public void run() {
            while (!shutdown) {
                Runnable task = workQueue.poll();
                try {
                    task.run();
                } catch (java.lang.Exception e) {
                    // Exception handling.
                }
            }
        }
    }
}
