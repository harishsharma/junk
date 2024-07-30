package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SettableFuture<T> implements Future<T> {

    private T result;
    private java.lang.Exception exception;
    private final Lock lock;
    private Condition done;
    private State state;


    public SettableFuture() {
        this.lock = new ReentrantLock();
        this.state = State.RUNNING;
        this.done = lock.newCondition();
    }


    public void setResults(T result) {
        lock.lock();
        try {
            this.result = result;
            this.state = State.COMPLETED;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void setException(java.lang.Exception e) {
        lock.lock();
        try {
            this.exception = e;
            this.state = State.FAILED;
            done.signalAll();
        } finally {
            lock.unlock();
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
        return state != State.RUNNING;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        lock.lock();
        try {
            while (!isDone()) {
                done.await();
            }
            if (state == State.COMPLETED) {
                return result;
            }
            throw new ExecutionException(exception);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    enum State {
        RUNNING, COMPLETED, FAILED
    }
}
