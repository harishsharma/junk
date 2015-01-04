package rxjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * RX java features etc.
 * 
 * @author harish.sharma
 *
 */
public class RxJavaExample {

    private String[]              values = null;
    private final ExecutorService executor;

    public RxJavaExample(final String[] values) {
        this.values = values;
        this.executor = Executors.newFixedThreadPool(4);
    }

    public void sayHello() {
        Observable.from(values).subscribe(str -> System.out.println("Hello " + str));
    }

    public String fetchArticles(String[] listOfArticles) {
        Observable<String> ob = Observable.create(subs -> {
            try {
                for (String articleName : listOfArticles) {
                    if (true == subs.isUnsubscribed()) {
                        return;
                    }
                    subs.onNext(new URL("http://en.wikipedia.org/wiki/" + articleName).toString());
                }
                if (false == subs.isUnsubscribed()) {
                    subs.onCompleted();
                }
            } catch (Throwable t) {
                if (false == subs.isUnsubscribed()) {
                    subs.onError(t);
                }
            }
        });
        ob.subscribe(it -> System.out.println(it));
        return null;
    }

    public void githubExe() {
        Observable<String> requests = Observable.just("https://api.github.com/users/harishsharma",
                "https://api.github.com/users/harish", "https://api.github.com/users");

        Observable<String> response = requests.flatMap(request -> {
            return Observable.create(new Observable.OnSubscribe<String>() {

                @Override
                public void call(Subscriber<? super String> subs) {
                    try {
                        if (true == subs.isUnsubscribed()) {
                            return;
                        }
                        subs.onNext(calculateResponse(request));

                        if (false == subs.isUnsubscribed()) {
                            subs.onCompleted();
                        }
                    } catch (Throwable t) {
                        if (false == subs.isUnsubscribed()) {
                            subs.onError(t);
                        }
                    }
                }
            });
        });
        // response.subscribeOn(Schedulers.io()).
        response.subscribe(str -> System.out.println(str), e -> System.out.println("Error occured " + e),
                () -> System.out.println("On Complete"));

    }

    public void githubEx() {
        Observable<String> requests = Observable.just("https://api.github.com/users/harishsharma",
                "https://api.github.com/users/harish", "https://api.github.com/users");

        Observable<String> responseStream = requests.flatMap(request -> {
            return Observable.from(calculateFutResponse(request));
        });

        responseStream.subscribe(str -> System.out.println(str), e -> System.out.println("Error occured " + e),
                () -> System.out.println("On Complete"));
    }

    private Future<String> calculateFutResponse(String urlStr) {
        return executor.submit(() -> {
            return calculateResponse(urlStr);
        });
    }

    private String calculateResponse(String urlStr) throws IOException {
        System.out.println("Running in " + Thread.currentThread().getName());
        URL url = new URL(urlStr);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str + "\n");
        }
        return sb.toString();
    }

    void groupedEx() {
        Observable
                .just(1, 6, 3, 4, 5)
                .groupBy(val -> val % 2 == 0)
                .subscribe(
                        grouped -> grouped.toSortedList().subscribe(
                                val -> System.out.println(val + " " + grouped.getKey())));
    }

    void errorEx() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).doOnNext(integer -> {
            if (new Random().nextInt(10) + 1 == 5) {
                System.out.println("Error!");
                throw new RuntimeException("Boo!");
            }
        }).retry().distinct().subscribe(System.out::println);
    }

    void schedularEx() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Observable
                .range(1, 5)
                .map(integer -> {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("Map: (" + Thread.currentThread().getName() + ")");
                    return integer + 2;
                })
                .subscribeOn(Schedulers.computation())
                .subscribe(
                        integer -> System.out
                                .println("Got: " + integer + " (" + Thread.currentThread().getName() + ")"));
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] aa) throws InterruptedException {
        String[] values = { "harish", "neeraj"};
        RxJavaExample ex = new RxJavaExample(values);
        // ex.githubExe();
        // ex.executor.shutdown();
        ex.junk();
    }

    static class MyObserver implements Observer<String> {

        @Override
        public void onCompleted() {
            System.out.println("Completed");
        }

        @Override
        public void onError(Throwable e) {
            System.out.println(e);
        }

        @Override
        public void onNext(String t) {
            System.out.println(t + " inside " + Thread.currentThread().getName());
        }

    }

    static class MySubscriber extends Subscriber<String> {

        @Override
        public void onCompleted() {}

        @Override
        public void onError(Throwable e) {}

        @Override
        public void onNext(String t) {}
    }

    void junk() {
        Observable.just(1, 2, 3, 4, 5, 6, 7).startWith(Observable.just(1, 2, 4)).subscribe(x -> System.out.println(x));
    }
}
