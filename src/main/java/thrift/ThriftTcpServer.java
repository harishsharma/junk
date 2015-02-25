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
public class ThriftTcpServer {

    private final int        port;
    private volatile boolean isRunning = false;

    public ThriftTcpServer(final int port) {
        this.port = port;
    }

    public void start() {
        if (isRunning) {
            log.debug("Server already running at port [{}] ", port);
            return;
        }
        try {
            TServerSocket serverTransport = new TServerSocket(port);
            MathService.Processor<MathService.Iface> processor = new MathService.Processor<MathService.Iface>(
                    new MathServiceHandler());
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            isRunning = true;
            log.info("Starting server at port [{}]", port);
            server.serve();
        } catch (TTransportException e) {
            isRunning = false;
            log.error("Error occured while running server {}", e);
        }
    }

    public static void main(String[] args) {
        ThriftTcpServer server = new ThriftTcpServer(4000);
        server.start();
    }
}
