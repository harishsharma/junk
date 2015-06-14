package hackerrank;

/**
 * https://www.hackerrank.com/challenges/java-inheritence
 * 
 * @author harish.sharma
 *
 */
public class Inheritence {

    public static void main(String[] argh) {
        Adder X = new Adder();
        System.out.println("My superclass is: " + X.getClass().getSuperclass().getName());
        System.out.print(X.add(10, 32) + " " + X.add(10, 3) + " " + X.add(10, 10) + "\n");

    }

    private static class Adder extends Arithmatic {
        @Override
        public int add(int a, int b) {
            return a + b;
        }

    }

    private static abstract class Arithmatic {
        public abstract int add(int a, int b);
    }
}
