package rxjava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Example of Completable Future.
 * 
 * @author harish.sharma
 *
 */
public class CompletableFutureExample {

    public static void main(String[] arg) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside thread " + Thread.currentThread().getName());
            return "hello";
        }, executor);

        future.thenApply(x -> {
            System.out.println(x + " inside thread " + Thread.currentThread().getName());
            return true;
        });
        executor.shutdown();
    }
}
