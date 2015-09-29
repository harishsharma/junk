package interviewbit;

public class Plaindrom {
    public boolean isPalindrome(int a) {
        String x = String.valueOf(a);
        int len = x.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (x.charAt(i) != x.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Plaindrom().isPalindrome(121));
    }
}
