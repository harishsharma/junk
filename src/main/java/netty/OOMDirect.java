package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

public class OOMDirect {
    public static void main(String[] args) throws InterruptedException {
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        ByteBuf buf = allocator.directBuffer(65 * 1024 * 1024);
        buf.writeByte(1);

        ByteBuf buf1 = allocator.directBuffer(65 * 1024 * 1024);
        buf1.writeByte(1);

        ByteBuf buf2 = allocator.directBuffer(65 * 1024 * 1024);
        buf2.writeByte(1);

        ByteBuf buf3 = allocator.directBuffer(65 * 1024 * 1024);
        buf3.writeByte(1);

        ByteBuf buf4 = allocator.directBuffer(65 * 1024 * 1024);
        buf4.writeByte(1);

        ByteBuf buf5 = allocator.directBuffer(65 * 1024 * 1024);
        buf5.writeByte(1);


        Thread.sleep(10 * 60 * 1000);
        buf.release();
        buf1.release();
        buf2.release();
        buf3.release();
        buf4.release();
        buf5.release();
    }
}
