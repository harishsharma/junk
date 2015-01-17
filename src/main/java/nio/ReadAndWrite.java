package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadAndWrite {

    public static void main(String[] arf) throws IOException {
        try (FileInputStream in = new FileInputStream("src/main/resources/nio/source")) {
            FileChannel ch = in.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(2048);
            ch.read(buf);
            System.out.println(buf.capacity());
        } finally {}

    }
}
