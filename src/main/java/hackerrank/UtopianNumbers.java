package hackerrank;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/utopian-identification-number
 * 
 * @author harish.sharma
 *
 */
public class UtopianNumbers {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String a = in.next();
            if (Pattern.matches("^[a-z]{0,3}[0-9]{2,8}[A-Z]{3,}", a)) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
            }
        }
        in.close();
    }
}
