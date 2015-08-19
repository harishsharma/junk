package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.codechef.com/COSE2015/problems/CSTRIKE3
 * 
 * @author harish.sharma
 *
 */
class CSTRIKE3 {
    public static void main(String[] arg) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String input = in.readLine();
            solve(input);
        }
        in.close();
    }

    private static void solve(String input) {
        Set<Character> chars = new HashSet<>(26);
        int len = input.length();
        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            chars.add(ch);
            if (chars.size() == 26) break;
        }
        if (chars.size() % 2 == 0) {
            System.out.println("Terrorist");
        } else {
            System.out.println("Counter Terrorist");
        }
    }
}
