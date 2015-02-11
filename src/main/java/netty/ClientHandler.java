package netty;

import java.net.SocketAddress;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class ClientHandler extends ChannelOutboundHandlerAdapter {

    private final char message;

    public ClientHandler(final char message) {
        this.message = message;
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        log.debug("Write called for [{}]", ctx.channel());
        ctx.write(msg, promise);
    }

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress,
            ChannelPromise promise) throws Exception {
        log.debug("Connect called for [{}]", ctx.channel());
        // kick start the server.
        ctx.channel().writeAndFlush(message);
        log.debug("Done writing in connect.");
    }

    @Override
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        log.debug("Bind called for [{}] with address [{}]", ctx.channel(), localAddress);
        super.bind(ctx, localAddress, promise);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        log.debug("Flush called for [{}]", ctx.channel());
        super.flush(ctx);
    }

}
