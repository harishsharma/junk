package interviewbit;

import java.util.ArrayList;

/**
 * 
 * @author harish.sharma
 *
 */
public class MaxSet {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int len = a.size();
        long curMax = 0;
        long curRunningSum = 0;
        for (int i = 0; i < len; i++) {
            if (a.get(i) < 0) {
                curMax = Math.max(curMax, curRunningSum);
                curRunningSum = 0;
            } else {
                curRunningSum += a.get(i);
            }
        }
        curMax = Math.max(curMax, curRunningSum);

        int start = 0, end = 0;
        long thisSum = 0;
        for (int i = 0; i < len; i++) {
            if (a.get(i) < 0) {
                if (thisSum == curMax) {
                    break;
                } else {
                    thisSum = 0;
                    start = end = i + 1;
                }
            } else {
                thisSum += a.get(i);
                end++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>(end - start + 1);
        for (int i = start; i < end; i++) {
            list.add(a.get(i));
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1967513926);
        list.add(1540383426);
        list.add(-1303455736);
        list.add(-521595368);
        System.out.println(new MaxSet().maxset(list));
    }
}
