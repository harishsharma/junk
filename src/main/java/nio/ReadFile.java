package nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("src/main/resources/files/test.txt")));
        char[] myBuffer = new char[12];
        int bytesRead = 0;
        while ((bytesRead = in.read(myBuffer, 0, 12)) != -1) {
            System.out.println("Bytes read are " + bytesRead);
            System.out.println("Actual content -- " + new String(myBuffer));

        }
        in.close();
    }
}
