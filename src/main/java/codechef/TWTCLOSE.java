package codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.codechef.com/problems/TWTCLOSE
 * 
 * @author harish.sharma
 *
 */
class TWTCLOSE {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] ar = new boolean[n + 1];
        int k = in.nextInt();
        int counter = 0;
        for (int i = 0; i < k; i++) {
            String input = in.next();
            if (input.equals("CLOSEALL")) {
                Arrays.fill(ar, false);
                System.out.println(0);
                counter = 0;
            } else {
                int index = in.nextInt();
                if (ar[index] == true) {
                    counter--;
                    ar[index] = false;
                } else {
                    counter++;
                    ar[index] = true;
                }
                System.out.println(counter);
            }
        }
        in.close();
    }
}
