package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Find out the maximum sub-array of non negative numbers from an array. The sub-array should be continuous. That is, a
 * sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * 
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than
 * sub-array B if sum(A) > sum(B).
 * 
 * @author harish.sharma
 *
 */
public class MaxSet {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        System.out.println(new MaxSet().maxset(list));
        in.close();
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int len = a.size();
        int startIdx = 0, endIdx = 0;
        int curSum = 0;
        int maxSum = 0;
        int curStart = 0, curEnd = 0;
        for (int i = 0; i < len; i++) {
            int curNum = a.get(i);
            if (curNum < 0) {
                if (curSum > maxSum) {
                    startIdx = curStart;
                    endIdx = curEnd;
                } else if (curSum == maxSum) {
                    if ((curEnd - curStart) > (endIdx - startIdx)) {
                        startIdx = curStart;
                        endIdx = curEnd;
                    }
                }
                curStart = i + 1;
                curEnd = curStart;
                curSum = 0;
            }
            curSum += curNum;
            curEnd++;
        }
        if (curSum > maxSum) {
            startIdx = curStart;
            endIdx = curEnd;
        } else if (curSum == maxSum) {
            if ((curEnd - curStart) > (endIdx - startIdx)) {
                startIdx = curStart;
                endIdx = curEnd;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = startIdx; i < endIdx; i++) {
            list.add(a.get(i));
        }
        return list;
    }
}
