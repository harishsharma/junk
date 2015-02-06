package netty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class JavaClient {

    private static final String HOST = "localhost";
    private static final int    PORT = 4000;

    public void createAndStartClient(byte message, int iterations) throws UnknownHostException, IOException,
            InterruptedException {
        Socket socket = new Socket(HOST, PORT);
        OutputStream io = socket.getOutputStream();
        for (int i = 0; i < iterations; i++) {
            io.write(message);
            Thread.sleep(15);
        }
        io.close();
        socket.close();
    }

    public static void main(String... args) throws UnknownHostException, IOException {
        JavaClient client = new JavaClient();
        int ITR = 2;
        new Thread(() -> {
            try {
                client.createAndStartClient((byte) 'A', ITR);
            } catch (Exception e) {}
        }).start();
        // new Thread(() -> {
        // try {
        // client.createAndStartClient((byte) 'B', ITR);
        // } catch (Exception e) {}
        // }).start();

    }
}
