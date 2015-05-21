package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/jim-and-the-orders
 * 
 * @author harish.sharma
 *
 */
public class Orders {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int sum = in.nextInt() + in.nextInt();
            pairs[i] = Pair.of(i, sum);
        }
        Arrays.sort(pairs, (x, y) -> x.getSecond() - y.getSecond());
        for (int i = 0; i < n; i++) {
            System.out.print(pairs[i].getFirst() + 1 + " ");
        }
        in.close();
    }

    private static class Pair {
        Integer first;
        Integer second;

        private Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }

        public static Pair of(int x, int y) {
            return new Pair(x, y);
        }

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }
    }
}
