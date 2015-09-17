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
            if (m == 1 || rate == 0) {
                System.out.printf("1000000000.0 0.0");
            } else if (rate == 1) {
                if (m % 2 == 0)
                    System.out.printf("0.0 1000000000.0");
                else
                    System.out.printf("1000000000.0 0.0");
            } else {
                double finalMoney = 1000000000.0 * Math.pow(m, rate);
                if (m % 2 == 0)
                    System.out.printf("%1.f %1.f", 10000000000.0 - finalMoney, finalMoney);
                else
                    System.out.printf("%1.f %1.f", finalMoney, 10000000000.0 - finalMoney);
            }
        }
        in.close();
    }
}
