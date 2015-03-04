package thrift;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

import lombok.extern.slf4j.Slf4j;

import thrift.MathService;

@Slf4j
@SuppressWarnings("rawtypes")
public class MathServiceHandlerAsync implements MathService.AsyncIface {


    @Override
    public void ping(AsyncMethodCallback resultHandler) throws TException {}

    @Override
    public void pingWithDelay(long delay, AsyncMethodCallback resultHandler) throws TException {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("bad thing happend");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void sum(int a, int b, AsyncMethodCallback resultHandler) throws TException {
        log.info("Server side sum request recieved");
        int result = a + b;
        resultHandler.onComplete(result);
    }

}
