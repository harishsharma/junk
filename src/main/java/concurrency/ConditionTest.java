package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author harish.sharma
 *
 */
public class ConditionTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition c = lock.newCondition();
        lock.lock();
        c.await();
        lock.unlock();
    }
}
