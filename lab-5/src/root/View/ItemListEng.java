package root.View;

import root.model.engines.Engine;

import javax.swing.*;
import java.awt.*;

public class ItemListEng extends JPanel {
    private JCheckBox delet;
    private Engine eng;
    private final JLabel viewEngName;
    private final JLabel viewEngFuel;
    private final JLabel viewEngRashod;
    private final JLabel viewEngPrice;

    public ItemListEng(Engine eng,Font f){
        super();
        this.eng=eng;
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        JPanel param = new JPanel();
        param.setLayout(new GridLayout(2,2,100,10));
        setBorder(BorderFactory.createTitledBorder("Двигатель типа: "+eng.getType()));
        ((javax.swing.border.TitledBorder) getBorder()).
                setTitleFont(f);
        viewEngName = new JLabel("Название двигателя: "+eng.getName());
        viewEngFuel = new JLabel("Количество топлива: "+eng.getFuel());
        viewEngRashod = new JLabel("Расход топлива: "+eng.getRashodTopliva());
        viewEngPrice = new JLabel("Цена двигателя: "+eng.getPrice());
        viewEngFuel.setFont(f);
        viewEngName.setFont(f);
        viewEngPrice.setFont(f);
        viewEngRashod.setFont(f);
        delet =new JCheckBox();
        delet.setVisible(false);
        param.add(viewEngName);
        param.add(viewEngFuel);
        param.add(viewEngRashod);
        param.add(viewEngPrice);
        add(param);
        add(delet);
    }

    public void setMyFont(Font f){
        if(f!=null){
        ((javax.swing.border.TitledBorder) getBorder()).setTitleFont(f);
        viewEngFuel.setFont(f);
        viewEngName.setFont(f);
        viewEngPrice.setFont(f);
        viewEngRashod.setFont(f);
        }
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
