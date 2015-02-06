package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Nio2Server {

    public void serve(final int port) throws IOException {
        log.debug("Listening for connection on {}", port);

        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
        InetSocketAddress localAddress = new InetSocketAddress(port);
        serverChannel.bind(localAddress);
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

            @Override
            public void completed(AsynchronousSocketChannel channel, Object attachment) {
                serverChannel.accept(null, this);
                ByteBuffer buffer = ByteBuffer.allocate(100);
                channel.read(buffer, buffer, new EchoCompletionHandler(channel));
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                log.error("Failed operation {}", exc);
                try {
                    serverChannel.close();
                } catch (IOException e) {
                    log.error("Failure while closing the channel {} is {}", serverChannel, e);
                }
            }
        });
    }

    private class EchoCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

        private final AsynchronousSocketChannel channel;

        public EchoCompletionHandler(final AsynchronousSocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void completed(Integer result, ByteBuffer attachment) {

        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            log.error("Failed operation ", exc);
            try {
                channel.close();
            } catch (IOException e) {
                log.error("Error occured while closing the channel {} , {} ", channel, e);
            }
        }
    }
}
