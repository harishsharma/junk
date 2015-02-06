package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    private static final String HOST = "localhost";
    private static final int    PORT = 4000;

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.createAndCallClient('A');
    }

    public void createAndCallClient(final char message) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup(1);
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline p = ch.pipeline();
                    p.addLast(new ClientHandler(message));
                }
            });

            ChannelFuture f = b.connect(HOST, PORT).await();
            log.debug("Here");
            // for (int i = 0; i < 100; i++) {
            // f.channel().writeAndFlush(message);
            // }
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
