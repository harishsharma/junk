package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a string including 1, 0 and ?, return all matching strings. Char ? can match 0 and 1.
 * 
 * @author harish.sharma
 *
 */
public class BinaryMatching {

    public static List<String> solve(String str) {
        List<String> res = new ArrayList<>();
        if (str.length() == 0) return res;
        return solveInternal(str, 0, res);
    }

    private static List<String> solveInternal(String str, int i, List<String> res) {
        if (i == str.length()) {
            res.add(str);
            return res;
        }

        if (str.charAt(i) == '?') {
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(i, '0');
            solveInternal(sb.toString(), i + 1, res);
            sb.setCharAt(i, '1');
            solveInternal(sb.toString(), i + 1, res);
        } else {
            solveInternal(str, i + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solve(str));
        in.close();
    }
}
