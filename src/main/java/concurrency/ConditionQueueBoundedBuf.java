package concurrency;

public class ConditionQueueBoundedBuf extends BaseBoundedBuf {

    public ConditionQueueBoundedBuf(int size) {
        super(size);
    }

    @Override
    public synchronized int get() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        Integer item = doTake();
        notifyAll();
        return item;
    }

    @Override
    public synchronized void put(Integer item) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(item);
        notifyAll();
    }

    public static void main(String[] args) {
        final ConditionQueueBoundedBuf queue = new ConditionQueueBoundedBuf(10);
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
                Integer item = queue.get();
                System.out.println("Item " + item + " taken in thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };
        new Thread(run2).start();

    }
}
