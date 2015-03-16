package threads;

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
                Thread.sleep(20 * 1000);
            } catch (Exception e) {
                log.error("Exception {}", e);
            }
        });
        t1.start();
        Thread.sleep(3 * 1000);
        t1.interrupt();
    }
}
