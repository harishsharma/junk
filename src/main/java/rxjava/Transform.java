package rxjava;

import rx.Observable;
import rx.Observable.Transformer;
import rx.functions.Func1;

public class Transform {

    public static <T, R> Transformer<T, R> mapTransformer(Func1<T, R> map) {
        return new Transformer<T, R>() {

            @Override
            public Observable<R> call(Observable<T> t1) {
                return t1.map(map);
            }
        };
    }

    public static void main(String[] args) {
        Observable<Integer> ob = Observable.just(1, 2, 3, 4);
        Observable<Integer> obStr = ob.compose(mapTransformer(t -> 2 * t));
        obStr.subscribe(a -> System.out.println(a));
    }
}
