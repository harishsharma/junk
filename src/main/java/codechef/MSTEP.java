package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * https://www.codechef.com/SEPT15/problems/MSTEP
 * 
 * @author harish.sharma
 *
 */
class MSTEP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        for (int i = 0; i < tests; i++) {
            SortedMap<Integer, Pair> map = new TreeMap<>();
            int lines = Integer.parseInt(br.readLine());
            for (int j = 0; j < lines; j++) {
                String[] nums = br.readLine().split(" ");
                for (int k = 0; k < nums.length; k++) {
                    map.put(Integer.parseInt(nums[k]), new Pair(j, k));
                }
            }
            Iterator<Entry<Integer, Pair>> itr = map.entrySet().iterator();
            Entry<Integer, Pair> prev = itr.next();
            int count = 0;
            while (itr.hasNext()) {
                Entry<Integer, Pair> curr = itr.next();
                count += (Math.abs(curr.getValue().a - prev.getValue().a) + Math.abs(curr.getValue().b
                        - prev.getValue().b));

                prev = curr;
            }
            System.out.println(count);
        }
        br.close();
    }

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
