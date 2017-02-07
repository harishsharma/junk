package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FTask {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Void> task = new FutureTask<Void>(new Callable<Void>() {

            @Override
            public Void call() throws java.lang.Exception {
                System.out.println("This job is done.");
                Thread.sleep(100 * 1000);
                System.out.println("Wow finally done.");
                return null;
            }
        });

        // new Thread(task).start();
        // new Thread(task).start();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<?> f1 = service.submit(task);
        Future<?> f2 = service.submit(task);
        Runnable run = () -> {
            System.out.println("Running inside the runnable.");
        };
        Thread.sleep(10 * 1000);
        service.execute(run);
        System.out.println("Haha");
        f2.get();
        System.out.println("haha1");
        f1.get();
        System.out.println("haha2");
    }
}
