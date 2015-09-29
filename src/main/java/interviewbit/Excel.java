package interviewbit;

public class Excel {
    public int titleToNumber(String a) {
        int len = a.length();
        int k = len - 1;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.pow(26, k) * (a.charAt(i) - 'A' + 1);
            k--;
        }
        return res;
    }

    public String convertToTitle(int a) {
        StringBuilder sb = new StringBuilder();
        int n = a;
        if (n <= 26) {
            char ret = (char) ('A' + n - 1);
            return String.valueOf(ret);
        }
        while (n > 0) {
            int mod = n % 26;
            if (mod == 0) {
                sb.append('Z');
                n = n - 26;
            } else
                sb.append((char) ('A' + mod - 1));
            n = n / 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Excel().titleToNumber("ZZ"));
        System.out.println(new Excel().convertToTitle(702));
    }
}
