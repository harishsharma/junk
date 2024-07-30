package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Executor -- Done
ExecutorService -- Done
ScheduledExecutorService -- Done
Future -- Done
CountDownLatch -- Done
CyclicBarrier
Semaphore -- Done
ThreadFactory -- Done
BlockingQueue -- Done
DelayQueue --
Locks -- Done
Phaser
LiveLock implement
Condition
 */

public class BlockingQueue<T> {

    private final int capacity;
    private final Queue<T> queue;
    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public T poll() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            T item = queue.poll();
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public void offer(T item) {
        lock.lock();
        try {
            while (queue.size() >= capacity) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            queue.offer(item);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q = new BlockingQueue<>(2);
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Polled " +  q.poll() + " in " + Thread.currentThread().getName());
            }
        });
        consumer.start();
        q.offer(1);
        Thread.sleep(1000);
        System.out.println("Offered 1");
        q.offer(2);
        Thread.sleep(1000);
        System.out.println("Offered 2");
        q.offer(3);
        Thread.sleep(1000);
        System.out.println("Offered 3");
    }
}
