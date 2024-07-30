package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PromiseSupport<T> implements Future<T> {

    private static final int RUNNING = 1;
    private static final int DONE = 2;
    private static final int FAILED = 3;

    private T value;
    private java.lang.Exception exception;
    private volatile int status = RUNNING;
    private final Object lock;

    public PromiseSupport() {
        this.lock = new Object();
    }

    void done(T value) {
        synchronized (lock) {
            this.value = value;
            this.status = DONE;
            lock.notifyAll();
        }
    }

    void doneExceptionally(java.lang.Exception exception) {
        synchronized (lock) {
            this.exception = exception;
            this.status = FAILED;
            lock.notifyAll();
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return status > RUNNING;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        synchronized (lock) {
            while (!isDone()) {
                lock.wait();
            }
            if (status == DONE) {
                return value;
            }
            throw new ExecutionException(exception);
        }
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        synchronized (lock) {
            while (!isDone()) {
                lock.wait(timeout);
            }
            if (status == DONE) {
                return value;
            }
            throw new ExecutionException(exception);
        }
    }
}
