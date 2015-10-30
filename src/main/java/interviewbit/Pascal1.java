package interviewbit;

import java.util.ArrayList;

/**
 * 
 * @author harish.sharma
 *
 */
public class Pascal1 {
    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (a == 0) return res;

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if (a == 1) {
            return res;
        }
        ArrayList<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        res.add(second);
        if (a == 2) {
            return res;
        }
        int n = 3;
        while (n <= a) {
            Integer[] last = new Integer[second.size()];
            last = second.toArray(last);
            Integer[] latest = new Integer[last.length + 1];
            latest[0] = 1;
            latest[last.length] = 1;
            for (int i = 1; i < last.length; i++) {
                latest[i] = last[i - 1] + last[i];
            }
            ArrayList<Integer> latestLst = new ArrayList<>(last.length + 1);
            for (int i = 0; i <= last.length; i++) {
                latestLst.add(latest[i]);
            }
            res.add(latestLst);
            n++;
            second = latestLst;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Pascal1().generate(5));
    }
}
