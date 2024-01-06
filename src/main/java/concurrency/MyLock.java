package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 
 * @author harish.sharma
 *
 */
public class MyLock {

    private final ConcurrentMap<Long, Boolean> threadToOwner = new ConcurrentHashMap<>();
    private volatile boolean                   locked        = false;
    private final Object                       sync          = new Object();

    public MyLock() {}

    public void lock() {
        long owner = Thread.currentThread().getId();
        synchronized (sync) {
            Boolean isOwner = threadToOwner.get(owner);
            if (isOwner != null && true == isOwner) return;
            while (locked) {
                try {
                    sync.wait();
                } catch (InterruptedException e) {
                    // NOT sure how to handle.
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Got lock in thread " + Thread.currentThread().getName());
            threadToOwner.put(owner, true);
            locked = true;
        }
    }

    public void unlock() {
        long owner = Thread.currentThread().getId();
        synchronized (sync) {
            if (!threadToOwner.get(owner)) throw new IllegalMonitorStateException();
            locked = false;
            sync.notifyAll();
            System.out.println("releasing lock in thread " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {


        final MyLock lock = new MyLock();
        Runnable run = () -> {
            lock.lock();
            try {
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
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
