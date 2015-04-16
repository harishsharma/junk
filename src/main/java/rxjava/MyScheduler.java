package rxjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * 
 * @author harish.sharma
 *
 */
public class MyScheduler {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Observable<Integer> ob1 = Observable.create(sub -> {
            sub.onNext(1);
            sub.onNext(2);
            sub.onNext(3);
            sub.onNext(4);
            sub.onNext(5);
            sub.onCompleted();
        });
        Observable<Integer> ob3 = ob1.flatMap(x -> Observable.create(sub -> {
            if (x % 2 == 0) {
                new Thread(() -> {
                    try {
                        Thread.sleep(1 * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    sub.onNext(x);
                    sub.onCompleted();
                }).start();
            } else {
                sub.onNext(x);
                sub.onNext(x);
                sub.onCompleted();
            }
        }));

        ob3.subscribeOn(Schedulers.from(executor)).subscribe(MyScheduler.getObserver());
        Thread.sleep(10 * 1000);
        executor.shutdown();
    }

    public static Observer<Integer> getObserver() {
        Observer<Integer> myob = new Observer<Integer>() {

            @Override
            public void onCompleted() {
                System.out.println("Completed in Thread " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onNext(Integer t) {
                System.out.println("Onnext in Thread " + Thread.currentThread().getName());
                System.out.println("Integer " + t);
            }
        };
        return myob;
    }
}
