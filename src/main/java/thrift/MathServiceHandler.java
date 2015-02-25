package thrift;

import org.apache.thrift.TException;

import lombok.extern.slf4j.Slf4j;

import thrift.MathService;

/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class MathServiceHandler implements MathService.Iface {

    @Override
    public void ping() throws TException {}

    @Override
    public void pingWithDelay(long delay) throws TException {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("bad thing happend");
        }
    }

    @Override
    public int sum(int a, int b) throws TException {
        return a + b;
    }

}
