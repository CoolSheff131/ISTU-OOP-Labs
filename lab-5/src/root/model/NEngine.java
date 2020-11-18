package root.model;

import root.Interfaces.InterfaceLoading;
import root.model.engines.Engine;
import root.model.engines.ICEngine;

public class NEngine implements InterfaceLoading {

    @Override
    public Engine getEngine(ShopEngine shop, String name) {
        Engine engine = shop.search(name);
        return engine;
    }

    @Override
    public Engine getEngine() {
        return new ICEngine();
    }
}
