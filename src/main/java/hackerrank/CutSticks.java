package hackerrank;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks
 * 
 * @author harish.sharma
 *
 */
public class CutSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (map.containsKey(num)) {
                Integer newNum = map.get(num) + 1;
                map.put(num, newNum);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(n);
        int curNum = n;
        for (Integer count : map.values()) {
            curNum = curNum - count;
            if (curNum > 0) System.out.println(curNum);
        }
        in.close();
    }

}
