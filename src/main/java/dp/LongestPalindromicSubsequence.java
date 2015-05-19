package dp;

/**
 * Given a sequence, find the length of the longest palindromic subsequence in it. For example, if the given sequence is
 * “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it. “BBBBB” and
 * “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
 * 
 * @author harish.sharma
 *
 */
public class LongestPalindromicSubsequence {
    public static int solve(char[] str, int start, int end) {
        if (start == end) return 1;
        if (str[start] == str[end] && start + 1 == end) {
            return 2;
        }

        if (str[start] == str[end]) {
            return solve(str, start + 1, end - 1) + 2;
        }
        return Math.max(solve(str, start + 1, end), solve(str, start, end - 1));
    }

    // This problem can be solved using LCS of string and reverse of given string.

    public static void main(String[] args) {
        System.out.println(solve("BBABCBCAB".toCharArray(), 0, "BBABCBCAB".length() - 1));
        System.out.println(solve("GEEK".toCharArray(), 0, "GEEK".length() - 1));
        System.out.println(solve("ABABABA".toCharArray(), 0, "ABABABA".length() - 1));
    }
}
