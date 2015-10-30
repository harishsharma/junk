package interviewbit;

import java.util.ArrayList;

public class Plus1 {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int len = a.size();
        boolean isLastDigitNine = true;
        for (int i = len - 1; i >= 0; i--) {
            int valAtIndex = a.get(i);
            if (valAtIndex != 9) {
                a.set(i, valAtIndex + 1);
                isLastDigitNine = false;
                break;
            } else {
                a.set(i, 0);
                isLastDigitNine = true;
            }
        }
        ArrayList<Integer> res = new ArrayList<>(len + 1);
        if (isLastDigitNine) {
            res.add(1);
            res.addAll(a);
            return res;
        } else {
            res = a;
            while (true) {
                if (res.get(0) == 0)
                    res.remove(0);
                else
                    break;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(0);
        input.add(8);
        input.add(9);
        System.out.println(new Plus1().plusOne(input));
    }
}
