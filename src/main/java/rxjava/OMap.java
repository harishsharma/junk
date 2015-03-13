package rxjava;

import rx.Observable;

public class OMap {
    public static void main(String[] args) {
        Observable<Integer> ob = Observable.just(1, 2, 3, 4, 5);
        Observable<String> obStr = ob.map(t -> " t is " + t);
        obStr.subscribe(s -> System.out.println(s));
    }
}
