package hackerrank;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/valid-pan-format
 * 
 * @author harish.sharma
 *
 */
public class ValidPan {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String a = in.next();
            String pat = "^[A-Z]{5}[0-9]{4}[A-Z]{1}";
            if (Pattern.matches(pat, a)) {
                System.out.println("YES");
            } else
                System.out.println("NO");
        }
        in.close();
    }
}
