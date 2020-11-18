package root.View;

import root.ActionListeners.NumbersOnlyKeyListener;

import javax.swing.*;
import java.awt.*;


public class SearchJDialog extends JDialog {
    private final JTextField name;
    private final JTextField minPrice;
    private final JTextField maxRashod;
    private final JTextField maxFuel;
    private final JTextField minFuel;
    private final JTextField minRashod;
    private JTextField maxPrice;
    private final JButton close;
    private final JButton search;
    private final JCheckBox dis;
    private final JCheckBox iceng;
    private final JCheckBox jeteng;


    public JTextField getNameField() {return name;}

    public JTextField getMinPrice() {return minPrice;}

    public JTextField getMaxRashod() {return maxRashod;}

    public JTextField getMaxFuel() {return maxFuel;}

    public JTextField getMinFuel() {return minFuel;}

    public JTextField getMinRashod() {return minRashod;}

    public JTextField getMaxPrice() {return maxPrice;}

    public JButton getClose() {return close;}

    public JButton getSearch() {return search;}

    public JCheckBox getDis() {return dis;}

    public JCheckBox getIceng() {return iceng;}

    public JCheckBox getJeteng() {return jeteng;}

    public SearchJDialog(Frame owner){
        super(owner,"Поиск",false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(650, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel txtfield=new JPanel(new GridLayout(6,2,20,5));
        txtfield.setBorder(BorderFactory.createTitledBorder("Характеристики"));
        search = new JButton("Поиск");
        close = new JButton("Отмена");
        name=new JTextField();
        name.setColumns(25);
        setResizable(false);
        maxPrice=new JTextField();
        minPrice=new JTextField();
        maxPrice.setText("9999");
        minPrice.setText("0");
        maxFuel=new JTextField();
        minFuel=new JTextField();
        maxFuel.setText("9999");
        minFuel.setText("0");
        maxRashod=new JTextField();
        minRashod=new JTextField();
        maxRashod.setText("999999");
        minRashod.setText("0");

        maxPrice.addKeyListener(new NumbersOnlyKeyListener(maxPrice));
        minPrice.addKeyListener(new NumbersOnlyKeyListener(minPrice));
        maxFuel.addKeyListener(new NumbersOnlyKeyListener(maxFuel));
        minFuel.addKeyListener(new NumbersOnlyKeyListener(minFuel));
        maxRashod.addKeyListener(new NumbersOnlyKeyListener(maxRashod));
        minRashod.addKeyListener(new NumbersOnlyKeyListener(minRashod));
        txtfield.add(new JLabel("минимальное количество топливо"));
        txtfield.add(new JLabel("максимальное количество топлива"));
        txtfield.add(minFuel);
        txtfield.add(maxFuel);
        txtfield.add(new JLabel("минимальная цена"));
        txtfield.add(new JLabel("максимальная цена"));
        txtfield.add(minPrice);
        txtfield.add(maxPrice);
        txtfield.add(new JLabel("минимальный расход"));
        txtfield.add(new JLabel("максимальный расход"));
        txtfield.add(minRashod);
        txtfield.add(maxRashod);

        JPanel types = new JPanel(new FlowLayout());
        types.setBorder(BorderFactory.createTitledBorder("Типы двигателей"));
        dis = new JCheckBox("Дизельный двигатель");
        iceng = new JCheckBox("двигатель внутреннего сгорания");
        jeteng = new JCheckBox("Реактивный двигатель");
        types.add(dis);
        types.add(iceng);
        types.add(jeteng);
        txtfield.setVisible(true);

        JPanel param=new JPanel();
        param.setLayout(new BoxLayout(param,BoxLayout.Y_AXIS));
        param.add(new JLabel("Название Двигателя"));
        param.add(name);
        param.add(types);
        param.add(txtfield);
        add(param);
        add(search);
        add(close);
        setVisible(true);
    }

}
