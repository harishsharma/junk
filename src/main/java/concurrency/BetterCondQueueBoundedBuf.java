package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BetterCondQueueBoundedBuf {

    private final Integer[]     elems;
    private final ReentrantLock lock     = new ReentrantLock();
    private final Condition     notFull  = lock.newCondition();
    private final Condition     notEmpty = lock.newCondition();
    private int                 head, tail, count;

    public BetterCondQueueBoundedBuf(int size) {
        elems = new Integer[size];
    }

    public void put(Integer item) throws InterruptedException {
        lock.lock();
        try {
            while (isFull()) {
                notFull.await();
            }
            elems[tail] = item;
            if (++tail == elems.length) tail = 0;
            count++;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Integer take() throws InterruptedException {
        lock.lock();
        try {
            while (isEmpty()) {
                notEmpty.await();
            }
            Integer item = elems[head];
            elems[head] = null;
            if (++head == elems.length) head = 0;
            count--;
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        lock.lock();
        try {
            return count == 0;
        } finally {
            lock.unlock();
        }
    }

    public boolean isFull() {
        lock.lock();
        try {
            return count == elems.length;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        final BetterCondQueueBoundedBuf queue = new BetterCondQueueBoundedBuf(10);
        Runnable run1 = () -> {
            for (int i = 0; i < 11; i++) {
                try {
                    queue.put(i);
                    System.out.println("Item " + i + " put in thread " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(run1).start();

        Runnable run2 = () -> {
            try {
                Integer item = queue.take();
                System.out.println("Item " + item + " taken in thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };
        new Thread(run2).start();


    }
}
