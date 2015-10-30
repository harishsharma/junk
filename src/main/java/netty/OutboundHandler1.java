package netty;

import java.net.SocketAddress;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OutboundHandler1 extends ChannelOutboundHandlerAdapter {

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress,
            ChannelPromise promise) throws Exception {
        log.debug("Connect called for class [{}]", getClass().getName());
        super.connect(ctx, remoteAddress, localAddress, promise);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        log.debug("write called for class [{}]", getClass().getName());
        super.write(ctx, msg, promise);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.debug("exception called for class [{}]", getClass().getName());
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        log.debug("flush called for class [{}]", getClass().getName());
        super.flush(ctx);
    }

}
