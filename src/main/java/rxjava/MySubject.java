package rxjava;

import rx.Observable;
import rx.subjects.AsyncSubject;
import rx.subjects.Subject;

public class MySubject<T, R> extends Subject<T, R> {

    protected MySubject(rx.Observable.OnSubscribe<R> onSubscribe) {
        super(onSubscribe);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public boolean hasObservers() {
        return false;
    }

    public static void main(String[] args) {
        Subject<Integer, Integer> sub = AsyncSubject.<Integer>create();
        Observable<Integer> ints = Observable.just(1, 2, 3, 4);
        ints.subscribe(sub);
        sub.subscribe(t -> System.out.println(t));
        sub.onNext(1);
        sub.onCompleted();
    }
}
