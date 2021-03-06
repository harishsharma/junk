package thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class ThriftTcpServer implements Server {

    private final int port;

    public ThriftTcpServer(final int port) {
        this.port = port;
    }

    @Override
    public void start() {
        try {
            TServerSocket serverTransport = new TServerSocket(port);
            MathService.Processor<MathService.Iface> processor = new MathService.Processor<MathService.Iface>(
                    new MathServiceHandler());
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            log.info("Starting server at port [{}]", port);
            server.serve();
        } catch (TTransportException e) {
            log.error("Error occured while running server {}", e);
        }
    }

    public static void main(String[] args) throws Exception {
        ThriftTcpServer server = new ThriftTcpServer(4000);
        server.start();
    }
}
