package root.Graphics;

import root.ActionListeners.NumbersOnlyKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchJDialog extends JDialog {
    private final JTextField name;
    private final JTextField minPrice;
    private final JTextField maxRashod;
    private final JTextField maxFuel;
    private final JTextField minFuel;
    private final JTextField minRashod;
    private JTextField maxPrice;
     private String[]value=null;

    public SearchJDialog(Frame owner){
        super(owner,"Поиск",true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(650, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel txtfield=new JPanel(new GridLayout(6,2,20,5));
        txtfield.setBorder(BorderFactory.createTitledBorder("Характеристики"));
        JButton search=new JButton("Поиск");
        JButton close=new JButton("Отмена");

        name=new JTextField();
        name.setColumns(25);

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
        JCheckBox dis=new JCheckBox();
        JCheckBox iceng=new JCheckBox();
        JCheckBox jeteng=new JCheckBox();
        types.add(dis);
        types.add(new JLabel("Дизельный двигатель"));
        types.add(iceng);
        types.add(new JLabel("двигатель внутреннего сгорания"));
        types.add(jeteng);
        types.add(new JLabel("Реактивный двигатель"));

    close.addActionListener(e -> {
        value=null;
        dispose();
    });
    search.addActionListener(e -> {
        String stringDis="";
        String stringICeng="";
        String stringJeteng="";
        if(dis.isSelected())
            stringDis="Дизельный двигатель";
        if(iceng.isSelected())
            stringICeng="двигатель внутреннего сгорания";
        if(jeteng.isSelected())
            stringICeng="Реактивный двигатель";

        value=new String[]{name.getText(),stringDis,stringICeng,stringJeteng,maxFuel.getText(),minFuel.getText(),maxPrice.getText(),minPrice.getText(),maxRashod.getText(),minRashod.getText()};



        dispose();
    });
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
    public String[] getVal(){

        return value;
    }
}
