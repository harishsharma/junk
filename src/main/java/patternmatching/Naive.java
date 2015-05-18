package patternmatching;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all
 * occurrences of pat[] in txt[]. You may assume that n > m.
 * 
 * @author harish.sharma
 *
 */
public class Naive {

    public static void solve(char[] string, char[] pat) {

        int strlen = string.length;
        int patlen = pat.length;
        for (int i = 0; i < strlen - patlen + 1; i++) {
            int j, k = 0;
            for (j = i; j < i + patlen; j++, k++) {
                if (string[j] != pat[k]) {
                    break;
                }
            }
            if (j - i == patlen) System.out.println("Found at index " + i);
        }
    }

    public static void main(String[] args) {
        solve("Hello World".toCharArray(), "World".toCharArray());
        solve("Hello World".toCharArray(), "ello".toCharArray());
        solve("Hello World".toCharArray(), "lo".toCharArray());
    }
}
