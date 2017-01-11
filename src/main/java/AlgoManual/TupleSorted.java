package AlgoManual;

/**
 * Created by harish.sharma on 2/15/16.
 */
public class TupleSorted {

    public static void sorted(int[] ar) {
        int firstIndex = 0;
        int thirdIndex = ar.length - 1;
        int index = 0;
        while (index <= thirdIndex) {
            if (ar[index] == 1) {
                swap(ar, index, firstIndex);
                firstIndex++;
            } else if (ar[index] == 3) {
                swap(ar, index, thirdIndex);
                thirdIndex--;
            }
            index++;
        }
    }

    private static void swap(int[] ar, int index, int firstIndex) {
        int temp = ar[index];
        ar[index] = ar[firstIndex];
        ar[firstIndex] = temp;
    }

    public static void main(String[] args) {
        int[] ar = { 3, 1, 2, 1, 1, 2, 1, 3, 3};
        sorted(ar);
        for (int a : ar) {
            System.out.print(" " + a);
        }
    }
}
