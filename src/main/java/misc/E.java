package misc;

public class E {

    static {
        System.out.println("static");
        int i = 0;
        if (i == 0) throw new RuntimeException();
    }

    public static void main(String[] args) {
        System.out.println("Some thing");
    }
}
