package dp;

/**
 * Given two strings of size m, n and set of operations replace (R), insert (I) and delete (D) all at equal cost. Find
 * minimum number of edits (operations) required to convert one string into another.
 * 
 * @author harish.sharma
 *
 */
public class DistanceBetweenStrings {
    public static int solve(String a, String b) {
        char[] ac = a.toCharArray();
        int alen = ac.length;
        char[] bc = b.toCharArray();
        int blen = bc.length;
        int[][] C = new int[alen + 1][blen + 1];
        for (int i = 1; i <= alen; i++) {
            C[i][0] = i;
        }
        for (int i = 1; i <= blen; i++) {
            C[0][i] = i;
        }

        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (ac[i - 1] == bc[j - 1]) {
                    C[i][j] = Math.min(C[i - 1][j - 1], Math.min(C[i][j - 1] + 1, C[i - 1][j] + 1));
                } else {
                    C[i][j] = Math.min(C[i - 1][j - 1] + 1, Math.min(C[i][j - 1] + 1, C[i - 1][j] + 1));
                }
            }
        }
        return C[alen][blen];
    }

    public static void main(String[] args) {
        System.out.println(solve("SUB", "SUN"));
    }
}
