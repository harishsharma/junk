package thrift;

import java.io.IOException;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TNonblockingSocket;

import thrift.MathService.AsyncClient.sum_call;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TcpClientAsync {

    private final MathService.AsyncClient client;

    public TcpClientAsync(final String host, final int port) throws IOException {
        this.client = new MathService.AsyncClient(new TBinaryProtocol.Factory(), new TAsyncClientManager(),
                new TNonblockingSocket(host, port));
    }

    public void sum(final int a, final int b) throws TException {
        log.info("Calculating sum of {} , {}", a, b);
        client.sum(a, b, new SumCallback());
    }

    private class SumCallback implements AsyncMethodCallback<MathService.AsyncClient.sum_call> {

        @Override
        public void onComplete(sum_call response) {
            try {
                log.info("OnComplete called with result [{}]", response.getResult());
            } catch (TException e) {
                log.error("Exception while getting result out from thrift response", e);
            }
        }

        @Override
        public void onError(Exception exception) {
            log.error("OnError called with exception {}", exception);
        }

    }

    public static void main(String[] args) throws IOException, TException, InterruptedException {
        TcpClientAsync client = new TcpClientAsync("localhost", 4000);
        client.sum(2, 4);
        Thread.sleep(1 * 1000);
    }
}
