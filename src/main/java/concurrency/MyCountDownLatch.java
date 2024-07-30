package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyCountDownLatch {

    private int count;
    private final Lock lock;
    private final Condition reachedZero;

    public MyCountDownLatch(int count) {
        this.count = count;
        this.lock = new ReentrantLock();
        this.reachedZero = lock.newCondition();

    }

    public void await() throws InterruptedException {
        lock.lock();
        try {
            while (count != 0) {
                reachedZero.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void countDown() {
        lock.lock();
        try {
            if (count <= 0) throw new IllegalMonitorStateException();
            count--;
            if (count == 0) {
                reachedZero.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
