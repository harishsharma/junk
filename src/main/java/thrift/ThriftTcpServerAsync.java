package thrift;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThriftTcpServerAsync implements Server {

    private final int port;

    public ThriftTcpServerAsync(final int port) {
        this.port = port;
    }

    @Override
    public void start() {
        TNonblockingServerTransport serverTransport;
        try {
            serverTransport = new TNonblockingServerSocket(port);
            MathService.AsyncProcessor<MathService.AsyncIface> processor = new MathService.AsyncProcessor<MathService.AsyncIface>(
                    new MathServiceHandlerAsync());
            TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport).processor(processor));
            log.info("Starting server at port [{}]", port);
            server.serve();
        } catch (TTransportException e) {
            log.error("Error occured while running server {}", e);
        }
    }

    public static void main(String[] args) throws Exception {
        ThriftTcpServerAsync server = new ThriftTcpServerAsync(4000);
        server.start();
    }
}
