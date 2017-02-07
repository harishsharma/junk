package misc;

/**
 * 
 * @author harish.sharma
 *
 */
public class Shutdown {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.exit(1);
        }));
        //Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        //    System.exit(1);
       // }));
    }
}
