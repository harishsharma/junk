package random;

import java.util.Random;

public class TestRand {
    public static void main(String[] args) {
        Random rand = new Random(1);
        System.out.println(rand.nextInt());
    }
}
