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
        }
        io.close();
        socket.close();
    }

    public static void main(String... args) throws UnknownHostException, IOException {
        JavaClient client = new JavaClient();
        int ITR = 10;
        char[] charArray = { 'a'};
        for (int i = 0; i < charArray.length; i++) {
            Task t = new Task(client, ITR, charArray[i]);
            new Thread(t).start();
        }
    }

    private static class Task implements Runnable {
        private final JavaClient client;
        private final int        ITR;
        private final char       ch;

        public Task(final JavaClient client, final int ITR, final char ch) {
            this.ch = ch;
            this.client = client;
            this.ITR = ITR;
        }

        @Override
        public void run() {
            try {
                client.createAndStartClient((byte) ch, ITR);
            } catch (Exception e) {

            }
        }
    }
}
