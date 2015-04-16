package rxjava;

import rx.Observable;

public class SomeStuff {
    public static void main(String[] args) {
        Observable<Integer> ob1 = Observable.create(sub -> {
            sub.onNext(1);
            sub.onNext(2);
            sub.onNext(3);
            sub.onNext(4);
            try {
                Thread.sleep(1 * 1000);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            sub.onNext(5);
            sub.onNext(6);
            sub.onCompleted();
        });

        new Thread(() -> {
            ob1.subscribe(MyScheduler.getObserver());
        }).start();

        new Thread(() -> {
            ob1.subscribe(MyScheduler.getObserver());
        }).start();
    }
}
