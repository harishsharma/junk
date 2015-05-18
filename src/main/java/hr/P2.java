package hr;


/**
 * 
 * @author harish.sharma
 *
 */
public class P2 {

    private static int    MOD      = 1000000007;
    private static long[] facts    = new long[105];
    private static long[] inverses = new long[105];

    public static int[] getRanks(String[] words) {
        int len = words.length;
        int[] res = new int[len];
        initFacts();
        initModularInverses();
        for (int i = 0; i < len; i++) {
            res[i] = permutationNumber(words[i].toCharArray());
        }
        return res;
    }

    private static void initModularInverses() {
        for (int i = 1; i < 105; i++) {
            inverses[i] = modularInverse(facts[i], MOD - 2);
        }
    }

    private static int permutationNumber(char[] str) {
        int i, j;
        int len = str.length;
        int[] count = new int[26];
        for (i = 0; i < 26; i++)
            count[i] = 0;

        for (i = 0; i < len; i++)
            count[str[i] - 'a']++;

        long ans = 0;

        for (i = 0; i < len; i++) {
            for (j = 0; j < (str[i] - 'a'); j++) {
                if (count[j] > 0) {
                    count[j]--;
                    ans = (ans + findNumberCombinations(count)) % MOD;
                    count[j]++;
                }
            }
            count[str[i] - 'a']--;
        }
        return (int) ans;
    }

    private static long findNumberCombinations(int[] count) {
        int i;
        int len = 0;
        for (i = 0; i < 26; i++) {
            len = len + count[i];
        }

        long ans = facts[len];

        for (i = 0; i < 26; i++) {
            if (count[i] > 0) ans = (ans * inverses[count[i]]) % MOD;
        }
        return ans;
    }

    private static void initFacts() {
        int i;
        facts[0] = 1;
        for (i = 1; i < 105; i++)
            facts[i] = (i * facts[i - 1]) % MOD;
    }

    private static long modularInverse(long base, long exp) {
        if (exp == 0) return 1;
        long ans = modularInverse(base, exp / 2);
        ans = (ans * ans) % MOD;
        if ((exp % 2) == 1) {
            ans = (ans * base) % MOD;
        }
        return ans;
    }
}
