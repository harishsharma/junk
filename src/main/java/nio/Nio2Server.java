package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

/**
 * NIO2 based server.
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class Nio2Server {

    private final int port;

    public Nio2Server(final int port) {
        this.port = port;
    }

    public void serve() throws IOException, InterruptedException {
        log.debug("Listening for connection on {}", port);

        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
        InetSocketAddress localAddress = new InetSocketAddress(port);
        serverChannel.bind(localAddress);
        final CountDownLatch latch = new CountDownLatch(1);
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
                    latch.countDown();
                }
            }
        });
        latch.await();
    }

    private class EchoCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

        private final AsynchronousSocketChannel channel;

        public EchoCompletionHandler(final AsynchronousSocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void completed(Integer result, ByteBuffer buffer) {
            buffer.flip();
            channel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {

                @Override
                public void completed(Integer result, ByteBuffer buffer) {
                    if (buffer.hasRemaining()) {
                        channel.write(buffer, buffer, this);
                    } else {
                        buffer.compact();
                        channel.read(buffer, buffer, EchoCompletionHandler.this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer buffer) {
                    handleError(exc);
                }
            });
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            handleError(exc);
        }

        private void handleError(Throwable exc) {
            log.error("Failed operation ", exc);
            try {
                channel.close();
            } catch (IOException e) {
                log.error("Error occured while closing the channel {} , {} ", channel, e);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Nio2Server server = new Nio2Server(4000);
        server.serve();
    }
}
