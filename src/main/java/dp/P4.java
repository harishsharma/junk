package dp;

/**
 * Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that
 * appears in the same relative order, but not necessarily contiguous.
 * 
 * @author harish.sharma
 *
 */
public class P4 {

    public static int solve(String a, String b) {
        char[] aChars = a.toCharArray();
        int alen = aChars.length;
        char[] bChars = b.toCharArray();
        int blen = bChars.length;
        int[][] lcs = new int[alen + 1][blen + 1];
        for (int i = 1; i < alen + 1; i++) {
            for (int j = 1; j < blen + 1; j++) {
                if (aChars[i - 1] == bChars[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }
        return lcs[alen][blen];
    }

    public static void main(String[] args) {
        System.out.println(solve("abcdgh", "aedfhr"));
        System.out.println(solve("AGGTAB", "GXTXAYB"));
    }
}
