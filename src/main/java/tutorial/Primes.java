package tutorial;

import java.util.ArrayList;
import java.util.List;

public class Primes {

    // Sieve of Eratosthenes
    // Find all primes from 2 to n

    public static List<Integer> solve(int n) {
        boolean[] res = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (res[i] == false) {
                for (int j = i; i * j <= n; j++) {
                    res[i * j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (res[i] == false) result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(200));
    }
}
