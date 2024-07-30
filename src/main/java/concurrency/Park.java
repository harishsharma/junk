package concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class Park {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean block = new AtomicBoolean(true);
        Runnable r = () -> {
            System.out.println("start");
            for (;;) {
                LockSupport.park();
                if (block.get() == false) break;
            }
            System.out.println("end");
        };
        Thread t = new Thread(r);
        t.start();
        Thread p = new Thread(r);
        p.start();
        Thread.sleep(2 * 1000);
        block.set(false);
        LockSupport.unpark(t);
        LockSupport.unpark(p);
    }
}
