package array;

/**
 * Reverse a string (this is a string => string a is this)
 * 
 * @author harish.sharma
 *
 */
public class ReverseLine {
    public static String solve(String a) {
        char[] aChars = a.toCharArray();
        int len = aChars.length;
        reverse(aChars, 0, len);
        int last = len;
        for (int i = len - 1; i > 0; i--) {
            if (aChars[i] == ' ') {
                reverse(aChars, i + 1, last);
                last = i;
            }
        }
        reverse(aChars, 0, last);
        return new String(aChars);
    }

    public static void reverse(char[] a, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            swap(a, i, j);
        }
    }

    public static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(solve("this is a string"));
    }
}
