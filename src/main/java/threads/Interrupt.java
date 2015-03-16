package threads;

import java.math.BigInteger;

import lombok.extern.slf4j.Slf4j;

/**
 * Interrupted Exception example.
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class Interrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                log.debug("Started working in {}", Thread.currentThread().getName());
                BigInteger p = new BigInteger("31");
                while (!Thread.currentThread().isInterrupted()) {
                    log.debug("Next prime is {}", p = p.nextProbablePrime());
                }
            } catch (Exception e) {
                log.error("Exception {}", e);
            }
        });
        t1.start();
        Thread.sleep(5 * 1000);
        t1.interrupt();
    }
}
