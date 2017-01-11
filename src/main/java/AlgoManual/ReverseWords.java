package AlgoManual;

/**
 * Created by harish.sharma on 2/27/16.
 */
public class ReverseWords {
    public static String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException("Null not allowed");

        char[] elems = input.toCharArray();
        char space = ' ';
        int start = 0;
        for (int i = 0; i < elems.length; i++) {
            if (elems[i] == space) {
                reverse(elems, start, i - 1);
                start = i + 1;
            }
        }
        reverse(elems, start, elems.length - 1);
        return new String(elems);
    }


    public static char[] reverse(char[] array, int start, int end) {
        int mid = start + (end - start) / 2;
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    public static void main(String[] ard) {
        String out = new String("Hi i am harish");
        char[] outt = out.toCharArray();
        String outt1 = new String(reverse(outt, 0, outt.length - 1));
        System.out.println((reverse(outt1)));
    }
}
