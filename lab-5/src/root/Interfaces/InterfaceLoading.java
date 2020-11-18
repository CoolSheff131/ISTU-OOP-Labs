package root.Interfaces;

import root.model.ShopEngine;
import root.model.engines.Engine;

public interface InterfaceLoading {
    public Engine getEngine(ShopEngine shop, String name);
    public Engine getEngine();

}
