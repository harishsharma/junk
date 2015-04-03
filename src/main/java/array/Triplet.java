package array;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Triplet<A, B, C> {
    private final A first;
    private final B second;
    private final C third;

    public static <A, B, C> Triplet<A, B, C> of(final A a, final B b, final C c) {
        return new Triplet<A, B, C>(a, b, c);
    }
}
