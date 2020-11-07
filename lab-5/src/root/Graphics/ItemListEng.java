package root.Graphics;

import root.CLASSES.Engine;

import javax.swing.*;
import java.awt.*;

public class ItemListEng extends JPanel {
    public ItemListEng(Engine eng){
        super();

        setLayout(new GridLayout(2,2,1,10));
        setBorder(BorderFactory.createTitledBorder("Двигатель типа: "+eng.getType()));
        JLabel viewEngName = new JLabel("Название двигателя: "+eng.getName());
        JLabel viewEngFuel = new JLabel("Количество топлива: "+eng.getFuel());
        JLabel viewEngRashod = new JLabel("Расход топлива: "+eng.getRashodTopliva());
        JLabel viewEngPrice = new JLabel("Цена двигателя: "+eng.getPrice());
        add(viewEngName);
        add(viewEngFuel);
        add(viewEngRashod);
        add(viewEngPrice);

    }
}
