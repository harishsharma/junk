package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-regex
 * 
 * @author harish.sharma
 *
 */
public class JavaRegex {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            String ma = new myRegex().pattern;
            System.out.println(IP.matches(ma));
        }
        in.close();
    }

    private static class myRegex {
        public String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    }
}
