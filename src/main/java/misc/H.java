package misc;

import javax.inject.Inject;

public class H implements IH {

    private final IG g;

    @Inject
    public H(IG g) {
        this.g = g;
        g.call();
    }

    @Override
    public void call() {
        System.out.println("H");
    }
}
