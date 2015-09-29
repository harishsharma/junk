package interviewbit;

import java.util.ArrayList;

public class Move {

    public int firstMissingPositive(ArrayList<Integer> a) {
        int len = a.size();
        if (len == 1 && a.get(0) != 1) return 1;
        if (len == 1 && a.get(0) == 1) return 2;
        for (int i = 0; i < len;) {
            int valAtIndex = a.get(i);
            if (valAtIndex <= 0 || valAtIndex > len) {
                i++;
                continue;
            }
            if (valAtIndex > i) {
                int t = a.get(valAtIndex - 1);
                a.set(valAtIndex - 1, valAtIndex);
                a.set(i, t);
                if (t == valAtIndex) i++;
            } else {
                a.set(valAtIndex - 1, valAtIndex);
                i++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (a.get(i) != (i + 1)) return i + 1;
        }
        return len + 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        System.out.println(new Move().firstMissingPositive(li));
    }
}
