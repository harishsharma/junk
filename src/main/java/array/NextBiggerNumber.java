package array;

/**
 * find next bigger number with same digits.
 * 
 * @author harish.sharma
 *
 */
public class NextBiggerNumber {
    public static int solve(Integer a) {
        char[] aStr = a.toString().toCharArray();
        int len = aStr.length;
        int i;
        for (i = len - 1; i > 1; i--) {
            if (aStr[i] > aStr[i - 1]) break;
        }
        if (i == 1 && aStr[i] < aStr[i - 1]) return -1;
        int ele = aStr[i - 1] - '0';
        int minMax = aStr[i] - '0';
        int minMaxIdx = i;
        for (int j = i; j < len; j++) {
            int cur = aStr[j] - '0';
            if (cur < minMax && cur > ele) {
                minMax = cur;
                minMaxIdx = j;
            }
        }
        swap(aStr, i - 1, minMaxIdx);
        sort(aStr, i, len);
        return Integer.parseInt(new String(aStr));
    }

    private static void sort(char[] aStr, int i, int len) {
        for (int j = i; j < len; j++) {
            for (int k = j + 1; k < len; k++) {
                if (aStr[j] > aStr[k]) {
                    swap(aStr, j, k);
                }
            }
        }
    }

    private static void swap(char[] aStr, int j, int k) {
        char temp = aStr[j];
        aStr[j] = aStr[k];
        aStr[k] = temp;
    }

    public static void main(String[] args) {
        System.out.println(solve(1235972));
        System.out.println(solve(98765));
        System.out.println(solve(132));
    }
}
