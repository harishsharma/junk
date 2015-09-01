package codechef;

import java.util.Scanner;

/*
 * https://www.codechef.com/problems/PALIN
 */
class NextPalindrom {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String val = in.next();
            solve(val);
        }
        in.close();
    }

    private static void solve(String val) {
        int len = val.length();
        // single digit
        if (len == 1) {
            int value = val.charAt(0) - '0';
            if (value < 9) {
                System.out.println(value + 1);
                return;
            } else {
                System.out.println(11);
                return;
            }
        }
        int[] arr = new int[len + 2];
        if (len % 2 == 0) {
            for (int i = 1; i <= len / 2; i++) {
                arr[i] = val.charAt(i - 1) - '0';
            }
            int mid = len / 2;
            int valAtNextToMid = (val.charAt(mid) - '0');
            if (arr[mid] == 9 && valAtNextToMid == 9) {
                int idx = mid;
                while (arr[idx] == 9) {
                    arr[idx] = 0;
                    if (arr[idx - 1] != 9) arr[idx - 1] += 1;
                    idx--;
                }
            } else {
                boolean shouldIncrease = false;

                for (int i = val.length() / 2 - 1, j = val.length() / 2; i >= 0; i--, j++) {
                    if (val.charAt(i) < val.charAt(j)) {
                        shouldIncrease = true;
                        break;
                    }
                }
                if (!shouldIncrease && val.charAt(0) == val.charAt(val.length() - 1)) shouldIncrease = true;

                if (shouldIncrease) arr[mid] += 1;
            }
            StringBuilder sb = new StringBuilder();
            boolean lessZero = false;
            if (arr[0] != 0) {
                sb.append(arr[0]);
                lessZero = true;
            }
            for (int i = 1; i <= mid; i++) {
                sb.append(arr[i]);
            }
            if (lessZero) {
                mid = mid - 1;
            }
            for (int i = mid; i > 0; i--) {
                sb.append(arr[i]);
            }
            if (arr[0] != 0) sb.append(arr[0]);
            System.out.println(sb.toString());
        } else {
            int mid = len / 2 + 1;
            for (int i = 1; i <= mid; i++) {
                arr[i] = val.charAt(i - 1) - '0';
            }
            if (arr[mid] == 9) {
                int idx = mid;
                while (arr[idx] == 9) {
                    arr[idx] = 0;
                    if (arr[idx - 1] != 9) arr[idx - 1] += 1;
                    idx--;
                }
            } else {
                boolean shouldIncrease = false;

                for (int i = val.length() / 2 - 1, j = val.length() / 2 + 1; i >= 0; i--, j++) {
                    if (val.charAt(i) < val.charAt(j)) {
                        shouldIncrease = true;
                        break;
                    }
                }
                if (!shouldIncrease && val.charAt(0) == val.charAt(val.length() - 1)) shouldIncrease = true;

                if (shouldIncrease) arr[mid] += 1;
            }

            StringBuilder sb = new StringBuilder();
            boolean lessZero = false;
            if (arr[0] != 0) {
                sb.append(arr[0]);
                lessZero = true;
            }
            for (int i = 1; i <= mid; i++) {
                sb.append(arr[i]);
            }
            if (lessZero) mid = mid - 1;
            for (int i = mid - 1; i > 0; i--) {
                sb.append(arr[i]);
            }
            if (arr[0] != 0) sb.append(arr[0]);
            System.out.println(sb.toString());
        }

    }
}
