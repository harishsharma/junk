package array;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author harish.sharma
 *
 * @param <T>
 * @param <R>
 */
@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Pair<T, R> {
    private final T first;
    private final R second;

    public static <T, R> Pair<T, R> of(final T first, final R second) {
        return new Pair<T, R>(first, second);
    }
}
