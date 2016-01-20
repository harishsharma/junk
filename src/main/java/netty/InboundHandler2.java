package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InboundHandler2 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("33channelRead called for class [{}]", getClass().getName());
        throw new RuntimeException();
        // super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("channelReadComplete called for class [{}]", getClass().getName());
    }

}
