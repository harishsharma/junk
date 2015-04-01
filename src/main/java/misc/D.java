package misc;

public class D implements A, B, C {

    @Override
    public void common() {
        System.out.println(getClass().getSuperclass().getName());
    }

    public static void main(String[] args) {
        new D().common();
    }
}
