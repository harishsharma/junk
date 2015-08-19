package misc;

import javax.inject.Inject;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class G implements IG {

    private final IH h;

    @Inject
    public G(IH h) {
        this.h = h;
        h.call();
    }

    @Override
    public void call() {
        System.out.println("G");
    }

    public static void main(String[] args) {
        Injector inj = Guice.createInjector(new IModule());
        IG g = inj.getInstance(IG.class);
        g.call();
    }
}
