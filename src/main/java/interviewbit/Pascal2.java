package interviewbit;

import java.util.ArrayList;

public class Pascal2 {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> res = null;

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        if (a == 0) {
            res = first;
            return res;
        }
        ArrayList<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        if (a == 1) {
            res = second;
            return res;
        }
        int n = 2;
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
            res = latestLst;
            n++;
            second = latestLst;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Pascal2().getRow(1));
        System.out.println(new Pascal2().getRow(2));
        System.out.println(new Pascal2().getRow(3));
        System.out.println(new Pascal2().getRow(4));
        System.out.println(new Pascal2().getRow(5));
    }
}
