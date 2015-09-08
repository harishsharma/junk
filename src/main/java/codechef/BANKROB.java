package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/SEPT15/problems/BANROB
 * 
 * @author harish.sharma
 *
 */
class BANKROB {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            float rate = in.nextFloat();
            float[] marr = new float[m];
            if (m == 1) {
                System.out.printf("1000000000.0 0.0");
            } else {
                for (int j = 0; j < m; j++) {
                    marr[j] = (float) (1000000000 * Math.pow(rate, j));
                }
                double diff = 0;
                for (int k = m - 1; k > 0; k--) {
                    diff = marr[k] - diff;
                }
                System.out.printf("%1.1f %1.1f", 1000000000.0 - diff, diff);
            }
        }
        in.close();
    }
}
