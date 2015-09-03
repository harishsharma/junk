package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/problems/SEAVOTE
 * 
 * @author harish.sharma
 *
 */
class SeaVote {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int sum = 0;
            int count = 0;
            for (int j = 0; j < num; j++) {
                int incom = in.nextInt();
                sum += incom;
                count = (incom == 0) ? count : count + 1;
            }
            if (sum < 100) {
                System.out.println("NO");
            } else {
                if ((sum - 99) <= count) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        in.close();
    }
}
