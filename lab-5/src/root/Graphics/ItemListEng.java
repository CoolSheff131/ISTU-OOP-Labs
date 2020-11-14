package root.Graphics;

import root.CLASSES.Engine;

import javax.swing.*;
import java.awt.*;

public class ItemListEng extends JPanel {
    private JCheckBox delet;
    private Engine eng;
    public ItemListEng(Engine eng){
        super();
        this.eng=eng;
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        JPanel param = new JPanel();
        param.setLayout(new GridLayout(2,2,100,10));
        setBorder(BorderFactory.createTitledBorder("Двигатель типа: "+eng.getType()));
        JLabel viewEngName = new JLabel("Название двигателя: "+eng.getName());
        JLabel viewEngFuel = new JLabel("Количество топлива: "+eng.getFuel());
        JLabel viewEngRashod = new JLabel("Расход топлива: "+eng.getRashodTopliva());
        JLabel viewEngPrice = new JLabel("Цена двигателя: "+eng.getPrice());
        delet =new JCheckBox();
        delet.setVisible(false);
        param.add(viewEngName);
        param.add(viewEngFuel);
        param.add(viewEngRashod);
        param.add(viewEngPrice);
        add(param);
        add(delet);
    }

    public Engine getEng() {
        return eng;
    }

    public boolean getDelet(){
        return delet.isSelected();
    }
    public void setDeletVisible(boolean visible){
        delet.setVisible(visible);
    }
}
