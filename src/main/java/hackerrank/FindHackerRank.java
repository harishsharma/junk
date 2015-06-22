package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/find-hackerrank
 * 
 * @author harish.sharma
 *
 */
public class FindHackerRank {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            boolean starts = Pattern.matches("hackerrank.*", a);
            boolean ends = Pattern.matches(".*hackerrank", a);
            if (starts && ends)
                System.out.println(0);
            else if (starts)
                System.out.println(1);
            else if (ends)
                System.out.println(2);
            else {
                System.out.println(-1);
            }
        }
        br.close();
    }
}
