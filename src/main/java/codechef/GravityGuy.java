package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/AUG15/problems/GRGUY
 * 
 * @author harish.sharma
 *
 */
class GravityGuy {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String line1 = in.next();
            char[] chars1 = line1.toCharArray();
            String line2 = in.next();
            char[] chars2 = line2.toCharArray();
            solve(chars1, chars2);
        }
        in.close();
    }

    private static void solve(char[] chars1, char[] chars2) {
        int len = chars1.length;
        for (int i = 0; i < len; i++) {
            if (chars1[i] == '#' && chars2[i] == '#') {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

        int jc1 = 0, jc2 = 0;
        if (chars1[0] == '.') {
            jc1 = jumpCount(chars1, chars2);
        }
        if (chars2[0] == '.') {
            jc2 = jumpCount(chars2, chars1);
        }
        int jc = 0;
        if (jc1 == 0)
            jc = jc2;
        else if (jc2 == 0)
            jc = jc1;
        else {
            jc = Math.min(jc1, jc2);
        }
        System.out.println(jc);
    }

    private static int jumpCount(char[] chars1, char[] chars2) {
        int len = chars1.length;
        int jumpCount1 = 0;
        boolean sw = true;
        for (int i = 1; i < len; i++) {
            if (sw) {
                if (chars1[i] == '.')
                    continue;
                else if (chars1[i] == '#') {
                    jumpCount1++;
                    sw = false;
                }
            } else {
                if (chars2[i] == '.')
                    continue;
                else if (chars2[i] == '#') {
                    jumpCount1++;
                    sw = true;
                }
            }
        }
        return jumpCount1;
    }
}
