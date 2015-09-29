package interviewbit;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author harish.sharma
 *
 */
public class PrimeSum {

    public ArrayList<Integer> primesum(int A) {
        Set<Integer> primes = solve(A);
        for (Integer i : primes) {
            if (primes.contains(A - i)) {
                return new ArrayList<Integer>() {
                    private static final long serialVersionUID = 1L;

                    {
                        add(i);
                        add(A - i);
                    }
                };
            }
        }
        return null;
    }

    public static boolean IsPrime(int number) {
        if (number < 2) return false;
        if (number % 2 == 0) return (number == 2);
        int root = (int) Math.sqrt((double) number);
        for (int i = 3; i <= root; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static Set<Integer> solve(int n) {
        boolean[] res = new boolean[n + 1];
        Set<Integer> result = new TreeSet<>();
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
        System.out.println(new PrimeSum().primesum(24));
    }
}
