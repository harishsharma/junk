package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

public class Promise<T> extends PromiseSupport<T> {

    private Runnable nextAction;

    @Override
    void done(T value) {
        super.done(value);
        handleNextAction();
    }

    @Override
    void doneExceptionally(java.lang.Exception e) {
        super.doneExceptionally(e);
        handleNextAction();
    }

    private void handleNextAction() {
        if (nextAction != null) {
            nextAction.run();
        }
    }

    public Promise<T> doneAsync(Callable<T> callable, ExecutorService executor) {
        executor.submit(() -> {
            try {
                T res = callable.call();
                done(res);
            } catch (java.lang.Exception e) {
                doneExceptionally(e);
            }
        });
        return this;
    }

    public Promise<Void> thenAccept(Consumer<T> consumer) {
        Promise<Void> res = new Promise<>();
        this.nextAction = new AcceptAction<T>(this, res, consumer);
        return res;
    }

    public <R> Promise<R> thenApply(Function<T, R> function) {
        Promise<R> res = new Promise<>();
        this.nextAction = new ApplyAction<T, R>(this, res, function);
        return res;
    }

    class AcceptAction<T> implements Runnable {
        private Promise<T> prev;
        private Promise<Void> next;
        private Consumer<T> consumer;

        public AcceptAction(Promise<T> prev, Promise<Void> next, Consumer<T> consumer) {
            this.next = next;
            this.prev = prev;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            try {
                consumer.accept(prev.get());
                next.done(null);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class ApplyAction<T, R> implements Runnable {
        private Promise<T> prev;
        private Promise<R> next;
        private Function<T, R> function;

        public ApplyAction(Promise<T> prev, Promise<R> next, Function<T, R> function) {
            this.next = next;
            this.prev = prev;
            this.function = function;
        }

        @Override
        public void run() {
            try {
                next.done(function.apply(prev.get()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
