package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.debug("Channel Read called for [{}]", ctx.channel());
        ByteBuf buf = (ByteBuf) msg;
        try {
            byte[] b = new byte[buf.readableBytes()];
            buf.getBytes(0, b);
            log.info("Data read is [{}]", new String(b));
        } finally {
            ReferenceCountUtil.release(buf);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.debug("Channel Read Complete called for [{}]", ctx.channel());
    }

}
