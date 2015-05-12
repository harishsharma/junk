package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations of a string.
 * 
 * @author harish.sharma
 *
 */
public class P1 {
    public static List<String> solve(String s) {
        if (s == null || s.length() == 0) return new ArrayList<String>();

        if (s.length() == 1) {
            List<String> res = new ArrayList<>();
            res.add(s);
            return res;
        }
        List<String> result = solve(s.substring(1));
        char first = s.charAt(0);
        List<String> finalRes = new ArrayList<>();
        for (String word : result) {
            int len = word.length();
            for (int i = 0; i <= len; i++) {
                finalRes.add(word.substring(0, i) + first + word.substring(i));
            }
        }
        return finalRes;
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(solve(s));
    }
}
