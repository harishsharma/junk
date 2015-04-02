package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
 * one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author harish.sharma
 *
 */
public class P2 {

    public boolean solve(final String word, final Set<String> dictWords) {
        if (dictWords.contains(word)) return true;
        int len = word.length();
        for (int i = 1; i < len - 1; i++) {
            String s = word.substring(0, i);
            if (dictWords.contains(s)) {
                boolean result = solve(word.substring(i), dictWords);
                if (result) {
                    return result;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        dict.add("le");
        dict.add("el");
        System.out.println(new P2().solve("leetcode", dict));
        Set<String> dict1 = new HashSet<>();
        dict1.add("programcree");
        dict1.add("program");
        dict1.add("creek");
        System.out.println(new P2().solve("programcreek", dict1));

    }
}
