package thrift;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThriftTcpServerNonBlocking implements Server {

    private final int port;

    public ThriftTcpServerNonBlocking(final int port) {
        this.port = port;
    }

    @Override
    public void start() {
        TNonblockingServerTransport serverTransport;
        try {
            serverTransport = new TNonblockingServerSocket(port);
            MathService.Processor<MathService.Iface> processor = new MathService.Processor<MathService.Iface>(
                    new MathServiceHandler());
            TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport).processor(processor));
            log.info("Starting server at port [{}]", port);
            server.serve();
        } catch (TTransportException e) {
            log.error("Error occured while running server {}", e);
        }
    }

    public static void main(String[] args) throws Exception {
        ThriftTcpServerNonBlocking server = new ThriftTcpServerNonBlocking(4000);
        server.start();
    }
}
