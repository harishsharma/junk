package netty;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
@Sharable
public class InboundHandler3 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // log.debug("Channel Read called for [{}]", ctx.channel());
        // ByteBuf buf = (ByteBuf) msg;
        // try {
        // byte[] b = new byte[buf.readableBytes()];
        // buf.getBytes(0, b);
        // log.info("Data read is [{}] in Thread {}", new String(b), Thread.currentThread().getName());
        // ctx.write(Unpooled.copiedBuffer(buf));
        // // ctx.fireChannelRead(Unpooled.copiedBuffer(buf));
        // Random r = new Random();
        // if (r.nextInt() % 5 == 0) {
        // Thread.sleep(5 * 1000);
        // }
        // } finally {
        // ReferenceCountUtil.release(buf);
        // }
        log.info("Channel Read  called for [{}]", ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("Handling this ex");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.debug("Channel Read Complete called for [{}]", ctx.channel());
    }

}
