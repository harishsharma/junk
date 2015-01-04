package rxjava;

import java.net.URL;
import java.util.stream.Stream;

/**
 * Streams in java 8.
 * 
 * @author harish.sharma
 *
 */
public class StreamExample {

    private final String[] listOfArticles;

    public StreamExample(final String... listOfArticles) {
        this.listOfArticles = listOfArticles;
    }

    public void printList() {
        Stream.of(listOfArticles).forEach(str -> System.out.println(str));
    }

    public void callWiki() {
        Stream.of(listOfArticles).filter(str -> !str.contains("hii")).forEach(str -> {
            try {
                URL url = new URL("http://www.google.com/" + str);
                int contentLen = url.openConnection().getContentLength();
                System.out.println(str + " == " + contentLen);
            } catch (Exception e) {
                System.out.println("Error occured" + e);
            }
        });
    }

    public static void main(String... arg) {
        StreamExample ex = new StreamExample("harish", "hii");
        ex.callWiki();
    }
}
