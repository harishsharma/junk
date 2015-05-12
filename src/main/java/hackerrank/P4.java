package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-digits
 * 
 * @author harish.sharma
 *
 */
public class P4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr = new int[10];
            int backN = n;
            while (n > 0) {
                int rem = n % 10;
                n = n / 10;
                if (rem != 0) if (backN % rem == 0) arr[rem] += 1;
            }
            int sum = 0;
            for (int j = 1; j < 10; j++) {
                sum += arr[j];
            }
            System.out.println(sum);
        }
        in.close();
    }
}
