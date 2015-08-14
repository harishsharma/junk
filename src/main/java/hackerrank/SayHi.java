package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/saying-hi
 * 
 * @author harish.sharma
 *
 */
public class SayHi {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            String b = a.toLowerCase();
            if (Pattern.matches("^hi [^d].*", b)) System.out.println(a);
        }
        br.close();
    }
}
