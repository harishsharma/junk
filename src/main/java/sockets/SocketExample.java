package sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Basic client server using sockets.
 * 
 * @author harish.sharma
 *
 */
public class SocketExample {

    public static void main(String[] args) throws IOException {

        new Thread(() -> {
            try {
                Thread.sleep(1 * 1000);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            Client c = new Client();
            try {
                c.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Server().run();
    }

    public static class Client {
        public void run() throws UnknownHostException, IOException {
            Socket sock = new Socket("localhost", 4000);
            System.out.println("Host add " + sock.getInetAddress().getHostAddress() + " Port " + sock.getPort());
            OutputStream out = sock.getOutputStream();
            out.write("Hi".getBytes());
            sock.close();
        }
    }

    public static class Server {
        public void run() throws IOException {
            ServerSocket ssock = new ServerSocket(4000);
            Socket sock = ssock.accept();
            System.out.println("Host add " + sock.getInetAddress().getHostAddress() + " Port " + sock.getPort());
            InputStream in = sock.getInputStream();
            int b = in.read();
            System.out.println("read something " + b);
            sock.close();
            ssock.close();
        }
    }
}
