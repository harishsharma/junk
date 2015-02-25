package rxjava;


import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class LiftStuff {

    public static <R, T> Observable<R> liftStuff(Observable<T> source, Func1<T, R> fun) {

        Operator<R, T> funOp = new Operator<R, T>() {

            @Override
            public Subscriber<? super T> call(Subscriber<? super R> t1) {
                return new Subscriber<T>() {

                    @Override
                    public void onCompleted() {
                        t1.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        t1.onError(e);
                    }

                    @Override
                    public void onNext(T t) {
                        try {
                            t1.onNext(fun.call(t));
                        } catch (Throwable e) {
                            onError(e);
                        }
                    }
                };
            }
        };

        return source.lift(funOp);
    }


    public static <T, R> Observable<R> map(Observable<T> source, Func1<T, R> maped) {

        Operator<R, T> mapOp = new Operator<R, T>() {

            @Override
            public Subscriber<? super T> call(Subscriber<? super R> t1) {
                return new Subscriber<T>() {

                    @Override
                    public void onCompleted() {
                        t1.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        t1.onError(e);
                    }

                    @Override
                    public void onNext(T t) {
                        t1.onNext(maped.call(t));
                    }
                };
            }
        };
        return source.lift(mapOp);
    }

    public static void main(String[] args) {
        Observable<Integer> source = Observable.just(1, 2, 3, 4, 5, 6, 7);

        Subscriber<Double> subs = new Subscriber<Double>() {

            @Override
            public void onCompleted() {
                log.debug("Completed in [{}]", Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                log.debug("Errored occurred in [{}] and details {}", Thread.currentThread().getName(), e);

            }

            @Override
            public void onNext(Double t) {
                log.debug("Value received [{}] in [{}]", t, Thread.currentThread().getName());
            }
        };

        Observable<Double> result = map(source, x -> 2.0 * x);
        result.subscribe(subs);
    }
}
