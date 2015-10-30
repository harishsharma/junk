package interviewbit;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author harish.sharma
 *
 */
public class Reach {
    public int coverPoints(List<Integer> X, List<Integer> Y) {
        int len = X.size();
        int prevX = X.get(0);
        int prevY = Y.get(0);
        int res = 0;
        for (int i = 1; i < len; i++) {
            int curX = X.get(i);
            int curY = Y.get(i);
            int xDiff = Math.abs(curX - prevX);
            int yDiff = Math.abs(curY - prevY);
            res += (Math.min(xDiff, yDiff)) + Math.abs(xDiff - yDiff);
            prevX = curX;
            prevY = curY;
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] x = { 4, 8, -7, -5, -13, 9, -7, 8};
        List<Integer> X = Arrays.asList(x);;

        Integer[] y = { 4, -15, -10, -3, -13, 12, 8, -8};
        List<Integer> Y = Arrays.asList(y);;
        System.out.println(new Reach().coverPoints(X, Y));
    }
}
