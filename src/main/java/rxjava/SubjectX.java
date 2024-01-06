package rxjava;

import java.util.ArrayList;
import java.util.List;

public class SubjectX<T> {

    private List<ObserverX<T>> observers = new ArrayList<>();
    private T                  data;

    public void setData(T data) {
        this.data = data;
        notifyObservers();
    }

    public void registerObserver(final ObserverX<T> obs) {
        observers.add(obs);
    }

    public void deRegisterObserver(final ObserverX<T> obs) {
        observers.remove(obs);
    }

    public void notifyObservers() {
        for (ObserverX<T> obs : observers) {
            obs.onData(data);
        }
    }

    public static void main(String[] args) {
        SubjectX<Integer> mySub = new SubjectX<>();
        mySub.registerObserver(ObserverX.MY);
        mySub.setData(1);
    }
}
