package interviewbit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author harish.sharma
 *
 */
public class LargestNum {
    public String largestNumber(final List<Integer> a) {
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(a);
        copy.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer x, Integer y) {
                String xS = x.toString();
                String yS = y.toString();
                int minLen = Math.min(xS.length() - 1, yS.length() - 1);
                if (xS.length() != yS.length() && xS.substring(0, minLen + 1).equals(yS.substring(0, minLen + 1))) {
                    if (xS.length() > yS.length()) {
                        if (xS.charAt(minLen + 1) < xS.charAt(minLen)) {
                            return -(y.toString().compareTo(x.toString()));
                        }
                    } else {
                        if (yS.charAt(minLen + 1) < yS.charAt(minLen)) {
                            return -(y.toString().compareTo(x.toString()));
                        }
                    }
                }
                return y.toString().compareTo(x.toString());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < copy.size(); i++) {
            sb.append(copy.get(i));
        }
        while (sb.length() != 0) {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else
                break;
        }
        if (sb.length() == 0) return String.valueOf(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        System.out.println(new LargestNum().largestNumber(list));
    }
}
