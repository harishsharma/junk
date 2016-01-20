package concurrency;

public class SleepyBoundedBuf extends BaseBoundedBuf {

    public SleepyBoundedBuf(int size) {
        super(size);
    }

    @Override
    public int get() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isEmpty()) {
                    return doTake();
                }
            }
            Thread.sleep(100);
        }
    }

    @Override
    public void put(Integer item) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(item);
                    return;
                }
                Thread.sleep(100);
            }
        }

    }
}
