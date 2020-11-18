package root;

import root.View.MainPanelJFrame;
import root.Interfaces.InterfaceLoading;
import root.control.Controller;
import root.model.NEngine;
import root.model.ShopEngine;

public class Main {

public static void main(String args[]){

    InterfaceLoading loading = new NEngine();
    ShopEngine shop = new ShopEngine();
    MainPanelJFrame gr=new MainPanelJFrame();
    gr.setVisible(true);
    Controller controller = new Controller();
    controller.execute(loading,shop,gr);
}

}
