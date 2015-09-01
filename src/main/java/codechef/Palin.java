package codechef;

import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;

class Palin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        try {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                char[] arr = br.readLine().toCharArray();
                String str = new String(arr);
                int size = arr.length;
                boolean b = true;
                for (int i = 0; i < size; i++) {
                    if (arr[i] != '9') {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    String s = "";
                    for (int i = 0; i < size - 1; i++)
                        s += "0";
                    bos.write(("1" + s + "1\n").getBytes());
                } else {
                    for (int i = 0; i < size / 2; i++) {
                        arr[size - 1 - i] = arr[i];
                    }
                    String str1 = new String(arr);
                    if (str.compareTo(str1) < 0) {
                        bos.write(str1.getBytes());
                        bos.write("\n".getBytes());
                    } else {
                        int pos = size / 2;
                        if (size % 2 == 0) pos--;
                        int x = arr[pos] + 1 - 48, count = 0;
                        while (x > 9) {
                            arr[pos - count] = '0';
                            count++;
                            x = arr[pos - count] + 1 - 48;
                        }
                        arr[pos - count]++;
                        for (int j = 0; j < size / 2; j++) {
                            arr[size - j - 1] = arr[j];
                        }
                        bos.write(new String(arr).getBytes());
                        bos.write("\n".getBytes());
                    }
                }
            }
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
