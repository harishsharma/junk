package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exception {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(1);
        Callable<Void> call = new Callable<Void>() {

            @Override
            public Void call() throws java.lang.Exception {
                throw new RuntimeException("I am so bad");
            }
        };
        Runnable run = () -> {
            throw new RuntimeException("i am so bad");
        };
        ex.execute(run);
        ex.submit(call);
        System.out.println(ex);

        System.out.println(ex);
    }
}
