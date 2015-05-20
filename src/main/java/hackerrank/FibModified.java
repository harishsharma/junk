package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 * 
 * @author harish.sharma
 *
 */
public class FibModified {

    public static BigInteger fibM(Integer first, Integer second, int n) {
        BigInteger[] res = new BigInteger[n + 1];
        res[0] = new BigInteger("0");
        res[1] = new BigInteger(first.toString());
        res[2] = new BigInteger(second.toString());
        for (int i = 3; i <= n; i++) {
            res[i] = (res[i - 1].multiply(res[i - 1])).add(res[i - 2]);
        }
        return res[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int first = in.nextInt();
        int second = in.nextInt();
        int n = in.nextInt();
        System.out.println(fibM(first, second, n));
        in.close();
    }
}
