package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/split-number
 * 
 * @author harish.sharma
 *
 */
public class SplitNumber {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            String[] arr = a.split("-| ");
            System.out.printf("CountryCode=%s,LocalAreaCode=%s,Number=%s", arr[0], arr[1], arr[2]);
            System.out.println();
        }
        br.close();
    }
}
