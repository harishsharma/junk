package misc;

import com.google.inject.AbstractModule;

public class IModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IG.class).to(G.class);
        bind(IH.class).to(H.class);
    }

}
