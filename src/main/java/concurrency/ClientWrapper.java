package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientWrapper {
    private final Client client;
    private Lock commonLock = new ReentrantLock();
    private volatile boolean initDone = false;
    private Condition initComplete = commonLock.newCondition();
    private volatile int pendingRequest = 0;
    private Condition requestCompleted = commonLock.newCondition();

    public ClientWrapper(Client client) {
        this.client = client;
    }

    public void init() {
        commonLock.lock();
        try {
            if (initDone) {
                return;
            }
            client.init();
            // Exception handling.
        } finally {
            initDone = true;
            initComplete.signalAll();
            commonLock.unlock();
        }
    }

    public void request() throws InterruptedException {
        if (!initDone) {
            commonLock.lock();
            try {
                while (!initDone) {
                    initComplete.await();
                }
            } finally {
                commonLock.unlock();
            }
        }
        pendingRequest++;
        client.request();
        commonLock.lock();
        try {
            pendingRequest--;
            requestCompleted.signalAll();
        } finally {
            commonLock.unlock();
        }

    }

    public void close() throws InterruptedException {
        if (!initDone) {
            commonLock.lock();
            try {
                while (!initDone) {
                    initComplete.await();
                }
            } finally {
                commonLock.unlock();
            }
        }

        commonLock.lock();
        try {
            while (pendingRequest != 0) {
                requestCompleted.await();
            }
        } finally {
            commonLock.unlock();
        }

        client.close();

    }

}
