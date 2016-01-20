package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Deadlock {

    public void deadlock(Object a, Object b) {
        synchronized (a) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            synchronized (b) {
                System.out.println("Successfully");
            }
        }
    }

    static void test() {
        final Deadlock dead = new Deadlock();
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            dead.deadlock(a, b);
        }).start();
        new Thread(() -> {
            dead.deadlock(b, a);
        }).start();
    }

    private static Executor exe = Executors.newSingleThreadExecutor();


    public static void dead() {
        Runnable run1 = () -> {
            System.out.println("Running in thread " + Thread.currentThread().getName());
            System.out.println("hi");
        };
        Runnable run2 = () -> {
            System.out.println("Running in thread " + Thread.currentThread().getName());
            exe.execute(run1);
        };
        exe.execute(run2);
    }

    private final Object a = new Object();
    private final Object b = new Object();

    public void A() {
        synchronized (a) {
            synchronized (b) {
                System.out.println("Running in thread " + Thread.currentThread().getName());
            }
        }
    }

    public void B() {
        synchronized (b) {
            synchronized (a) {
                System.out.println("Running in thread " + Thread.currentThread().getName());
            }
        }
    }

    public void deadlock1(Deadlock dead) {
        new Thread(() -> {
            dead.A();
        }).start();

        new Thread(() -> {
            dead.B();
        }).start();
    }

    public static void main(String[] args) {
        test();
    }
}
