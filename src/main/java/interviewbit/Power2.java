package interviewbit;


public class Power2 {
    public boolean isPower(int A) {
        if (A == 1) return true;
        int n = A;
        for (int i = 2; i <= 31; i++) {
            for (int j = 2;; j++) {
                int pow = (int) Math.pow(j, i);
                if (pow > Integer.MAX_VALUE || pow > n) break;
                if (n == pow) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Power2().isPower(1024000000));
    }
}
