package root;

import root.View.MainJFrame;
import root.Interfaces.InterfaceLoading;
import root.control.Controller;
import root.model.NEngine;
import root.model.ShopEngine;

import java.util.HashMap;

public class Main {

public static void main(String args[]){
    InterfaceLoading loading = new NEngine();
    ShopEngine shop = new ShopEngine();
    MainJFrame gr = new MainJFrame();

    Controller controller = new Controller();
    controller.execute(loading,shop,gr);
}

}
