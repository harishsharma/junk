package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/hackerrank-tweets
 * 
 * @author harish.sharma
 *
 */
public class HackerTweets {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String a = br.readLine().toLowerCase();
            if (a.contains("hackerrank")) count++;
        }
        System.out.println(count);
        br.close();
    }
}
