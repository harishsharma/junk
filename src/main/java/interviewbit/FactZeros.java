package interviewbit;

public class FactZeros {
    public int trailingZeroes(int a) {
        int n = a;
        int sum = 0;
        int count = 1;
        while (n > 0) {
            int pow = (int) Math.pow(5, count);
            sum += n / pow;
            count++;
            if (n / pow <= 0) break;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new FactZeros().trailingZeroes(124));
    }
}
