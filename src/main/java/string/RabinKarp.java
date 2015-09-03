package string;

import java.math.BigInteger;
import java.util.Random;

/**
 * Rabin karp string matching algorithm.
 * 
 * @author harish.sharma
 *
 */
public class RabinKarp {

    private final String      pat;
    private static final Long bigPrime = BigInteger.probablePrime(31, new Random()).longValue();
    private final int         radix    = 256;
    private long              patHash;
    private int               M;
    private long              RM;

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        RM = 1;
        for (int i = 1; i <= M - 1; i++)
            RM = (radix * RM) % bigPrime;
        patHash = hash(pat, pat.length());
    }


    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (radix * h + key.charAt(j)) % bigPrime;
        return h;
    }

    private boolean check(String txt, int i) {
        for (int j = 0; j < M; j++)
            if (pat.charAt(j) != txt.charAt(i + j)) return false;
        return true;
    }

    public int search(String txt) {
        int N = txt.length();
        if (N < M) return N;
        long txtHash = hash(txt, M);

        // check for match at offset 0
        if ((patHash == txtHash) && check(txt, 0)) return 0;

        // check for hash match; if hash match, check for exact match
        for (int i = M; i < N; i++) {
            // Remove leading digit, add trailing digit, check for match.
            txtHash = (txtHash + bigPrime - RM * txt.charAt(i - M) % bigPrime) % bigPrime;
            txtHash = (txtHash * radix + txt.charAt(i)) % bigPrime;

            // match
            int offset = i - M + 1;
            if ((patHash == txtHash) && check(txt, offset)) return offset;
        }

        // no match
        return N;
    }

    public static void main(String[] args) {
        String pat = "hFrish";
        String txt = "arharish";

        RabinKarp searcher = new RabinKarp(pat);
        int offset = searcher.search(txt);

        // print results
        System.out.println("text:   " + txt + " at offset " + offset);
    }
}
