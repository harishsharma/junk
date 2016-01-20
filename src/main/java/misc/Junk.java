package misc;

import java.net.UnknownHostException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Junk {

    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        final Object lock = new Object();
        final Lock lck = new ReentrantLock();

        Runnable run = () -> {
            synchronized (lock) {
                try {
                    System.out.println("CUrrent thread is  " + Thread.currentThread().getName());
                    lck.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // lck.unlock();
                }
            }

        };

        for (int i = 0; i < 10; i++) {
            new Thread(run).start();
        }

        Thread.sleep(15 * 1000);
    }
}
