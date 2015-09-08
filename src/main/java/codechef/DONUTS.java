package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.codechef.com/SEPT15/problems/DONUTS
 * 
 * @author harish.sharma
 *
 */
class DONUTS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        for (int i = 0; i < tests; i++) {
            String[] nm = br.readLine().split(" ");
            int m = Integer.parseInt(nm[1]);
            int[] arr = new int[m];
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < strArr.length; j++)
                arr[j] = Integer.parseInt(strArr[j]);
            Arrays.sort(arr);
            int counter = m;
            int cuts = 0;
            int curIndex = 0;
            while (counter > 1) {
                if (arr[curIndex] == 1) {
                    counter -= 2;
                    curIndex++;
                    cuts++;
                } else {
                    counter -= 1;
                    arr[curIndex] -= 1;
                    cuts++;
                }
            }
            System.out.println(cuts);
        }
        br.close();
    }
}
