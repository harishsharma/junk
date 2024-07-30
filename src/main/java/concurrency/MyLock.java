package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author harish.sharma
 */
public class MyLock {

    private boolean locked = false;
    private Thread owner = null;

    public MyLock() {
    }

    public synchronized void lock() {
        while (locked) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("Getting the lock in " + Thread.currentThread().getName());
        locked = true;
        owner = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (owner != Thread.currentThread()) {
            throw new IllegalMonitorStateException();
        }
        locked = false;
        owner = null;
        notifyAll();
        System.out.println("Releasing the lock in " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {


        final MyLock lock = new MyLock();
        Runnable run = () -> {
            lock.lock();
            try {
                try {
                    // Thread.sleep(1 * 1000);
                } catch (java.lang.Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Running in thread " + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(run).start();
        }
    }
}
