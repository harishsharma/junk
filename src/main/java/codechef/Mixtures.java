package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Mixtures {
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void solve() throws IOException {
        String s;
        while ((s = in.readLine()) != null && s.length() > 0) {
            int n = Integer.parseInt(s);
            int[][] dp = new int[n][n];
            int[][] colors = new int[n][n];
            String[] next = in.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < n; i++) {
                int c = Integer.parseInt(next[i]);
                colors[i][i] = c;
                dp[i][i] = 0;
            }
            // first coordinate < second (always)
            for (int i = 0; i < n; i++) {
                for (int k = 1; k + i < n; k++) {
                    for (int j = i + 1; j <= i + k; j++) {
                        colors[i][j] = (colors[i][j - 1] + colors[j][j]) % 100;
                    }
                }
            }

            for (int offset = 1; offset < n; offset++) {
                for (int i = 0; i + offset < n; i++) {
                    int j = i + offset;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + colors[i][k] * colors[k + 1][j]);
                    }
                }
            }

            System.out.println(dp[0][n - 1]);
        }
        in.close();
    }

    public static void main(String[] args) throws IOException {
        new Mixtures().solve();
    }
}
