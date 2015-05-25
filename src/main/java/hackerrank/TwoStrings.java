package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/two-strings
 * 
 * @author harish.sharma
 *
 */
public class TwoStrings {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String a = in.next();
            String b = in.next();
            Set<Character> aChars = new HashSet<>();
            for (char aa : a.toCharArray()) {
                aChars.add(aa);
            }
            boolean isYes = false;
            for (char bb : b.toCharArray()) {
                if (aChars.contains(bb)) {
                    System.out.println("YES");
                    isYes = true;
                    break;
                }
            }
            if (!isYes) System.out.println("NO");
        }
        in.close();
    }
}
