package thrift;

import java.io.Closeable;
import java.io.IOException;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class TcpClient implements Closeable {

    private final MathService.Client client;
    private final TTransport         transport;

    public TcpClient(final String host, final int port, boolean isBlockingServer) throws TTransportException {
        if (isBlockingServer) {
            this.transport = new TSocket(host, port);
        } else {
            this.transport = new TFramedTransport(new TSocket(host, port));
        }
        this.transport.open();
        this.client = new MathService.Client(new TBinaryProtocol(transport));
    }

    public void ping() throws TException {
        client.ping();
        log.info("Ping request served");
    }

    public void pingWithDelay(long delay) throws TException {
        client.pingWithDelay(delay);
        log.info("Ping request server with delay [{}]", delay);
    }

    public int sum(final int a, final int b) throws TException {
        int result = client.sum(a, b);
        log.info("Sum request served for input {} , {} and returning result [{}]", a, b, result);
        return result;
    }

    @Override
    public void close() throws IOException {
        transport.close();
    }


    public static void main(String[] args) throws TException, IOException {
        TcpClient client = new TcpClient("localhost", 4000, false);
        client.ping();
        client.sum(1, 2);
        client.close();
    }
}
