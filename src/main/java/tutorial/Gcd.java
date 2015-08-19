package tutorial;

public class Gcd {

    // Euclid’s Gcd formula.
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(10, 8));
    }
}
