package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.codechef.com/problems/AND
 *
 */
class And {
    private static final BufferedReader in      = new BufferedReader(new InputStreamReader(System.in));
    private static int[]                counter = new int[32];

    public void solve() throws IOException {
        in.readLine();
        String[] next = in.readLine().split(" ");
        for (String s : next) {
            count(Integer.parseInt(s));
        }

        long result = 0;
        long power = 1l;
        for (int i = 0; i < 32; i++) {
            result += power * counter[i] * (counter[i] - 1) / 2;
            power *= 2;
        }

        System.out.println(result);
        in.close();
    }

    public static void count(int n) {
        int i = 0;
        while (n > 0) {
            counter[i] += n % 2;
            n >>= 1;
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        new And().solve();
    }
}
