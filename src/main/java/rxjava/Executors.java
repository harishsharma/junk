package rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Executors {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(1);
        List<Integer> nums = new ArrayList<Integer>() {
            private static final long serialVersionUID = -8954941286821192114L;

            {
                add(1);
                add(2);
                add(3);
            }
        };
        Observable<Integer> ints = getObservableFromList(nums);
        ints.subscribeOn(Schedulers.from(executor)).subscribe(new MySub<Integer>());
        executor.shutdown();
    }

    static <T> Observable<T> getObservableFromList(List<T> list) {
        Observable<T> result = Observable.create(new OnSubscribe<T>() {

            @Override
            public void call(Subscriber<? super T> sub) {
                try {
                    log.info("OnSubcribe Called in thread {}", Thread.currentThread().getName());
                    for (T item : list) {
                        sub.onNext(item);
                    }
                    sub.onCompleted();
                } catch (Exception e) {
                    sub.onError(e);
                }

            }
        });
        return result;
    }

    @Slf4j
    private static class MySub<T> implements Observer<T> {

        @Override
        public void onCompleted() {
            log.info("OnCompleted in thread {}", Thread.currentThread().getName());
        }

        @Override
        public void onError(Throwable e) {
            log.info("On Error with Error {} in thead {}", e, Thread.currentThread().getName());
        }

        @Override
        public void onNext(T t) {
            log.info("OnNext with item {} in thread {}", t, Thread.currentThread().getName());
        }

    }
}
