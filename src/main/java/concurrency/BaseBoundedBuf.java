package concurrency;

import javax.annotation.concurrent.GuardedBy;

public abstract class BaseBoundedBuf {
    @GuardedBy("this")
    private final Integer[] elems;
    @GuardedBy("this")
    private int             head, tail, count;

    protected BaseBoundedBuf(int size) {
        elems = new Integer[size];
    }

    protected synchronized Integer doTake() {
        int item = elems[head];
        elems[head] = null;
        if (++head == elems.length) head = 0;
        count--;
        return item;
    }

    protected synchronized void doPut(Integer item) {
        elems[tail] = item;
        if (++tail == elems.length) tail = 0;
        count++;
    }

    public synchronized boolean isFull() {
        return elems.length == count;
    }

    public synchronized boolean isEmpty() {
        return count == 0;
    }

    public abstract int get() throws InterruptedException;

    public abstract void put(Integer item) throws InterruptedException;
}
