package streams;

import java.util.stream.Stream;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * 
 * @author harish.sharma
 *
 */
@NotThreadSafe
public class Infinite {

    public static void main(String[] args) {
        Integer[] lst = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stream<Integer> lstStream = Stream.of(lst);
        lstStream.map(x -> x * 2).filter(x -> x == 4).findFirst();
    }
}
