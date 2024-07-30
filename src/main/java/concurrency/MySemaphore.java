package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySemaphore {

    private int permits;
    private final Lock lock;
    private final Condition permitsAvailable;

    public MySemaphore(int permits) {
        this.permits = permits;
        this.lock = new ReentrantLock();
        this.permitsAvailable = lock.newCondition();

    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits <= 0) {
                permitsAvailable.await();
            }
            permits--;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            permits++;
            permitsAvailable.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
