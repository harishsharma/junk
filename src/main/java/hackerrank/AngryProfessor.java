package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-professor
 * 
 * @author harish.sharma
 *
 */
public class AngryProfessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int lessThanZero = 0;
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                if (num <= 0) lessThanZero++;
            }
            if (lessThanZero >= k)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        in.close();
    }
}
