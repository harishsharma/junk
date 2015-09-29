package interviewbit;


public class Paths {

    public int uniquePaths(int a, int b) {

        int[][] dp = new int[a + 1][b + 1];
        dp[1][1] = 1;
        for (int i = 1; i < a + 1; i++) {
            for (int j = 1; j < b + 1; j++) {
                if (i == 1 && j == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[a][b];
    }

    public static void main(String[] args) {
        System.out.println(new Paths().uniquePaths(3, 3));
    }
}
