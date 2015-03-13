package rxjava;

public interface ObserverX<T> {

    void onData(T data);

    ObserverX<Integer> MY = new ObserverX<Integer>() {

                              @Override
                              public void onData(Integer data) {
                                  System.out.println("Received data " + data);
                              }
                          };
}
