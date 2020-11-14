package root.Graphics;

import root.ActionListeners.NumbersOnlyKeyListener;
import root.CLASSES.Diesel;
import root.CLASSES.Engine;
import root.CLASSES.ICEngine;
import root.CLASSES.JetEngine;
import root.ShopEngine;

import javax.swing.*;
import java.awt.*;

public class AddJDialog extends JDialog {
    private Engine eng;

    public AddJDialog(Frame owner){
        super(owner,"Добавить двигатель",true);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(600, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JButton addEngineButton = new JButton("Добавить Двигатель");
        JButton CloseAddPanelButton = new JButton("Отмена");

        JPanel txtfields=new JPanel(new GridLayout(2,4,10,10));
        JTextField txtname = new JTextField();
        JTextField txtfuel = new JTextField();
        JTextField txtprice = new JTextField();
        JTextField txtrashodTopliva = new JTextField();

        txtfuel.addKeyListener(new NumbersOnlyKeyListener(txtfuel));
        txtprice.addKeyListener(new NumbersOnlyKeyListener(txtprice));
        txtrashodTopliva.addKeyListener(new NumbersOnlyKeyListener(txtrashodTopliva));

        txtname.setColumns(10);
        txtprice.setColumns(10);
        txtfuel.setColumns(10);
        txtrashodTopliva.setColumns(10);

        txtfields.setBorder(BorderFactory.createTitledBorder("Характеристики"));
        txtfields.add(new JLabel("Имя двигателя"));
        txtfields.add(new JLabel("Расход Топлива"));
        txtfields.add(new JLabel("Цена двигателя"));
        txtfields.add(new JLabel("Количество топлива"));
        txtfields.add(txtname);
        txtfields.add(txtrashodTopliva);
        txtfields.add(txtprice);
        txtfields.add(txtfuel);

        JRadioButton dis=new JRadioButton("Дизельный двигатель");
        JRadioButton icEng=new JRadioButton("Двигатель внутреннего сгорания");
        JRadioButton jetEng=new JRadioButton("Турбо двигатель");
        JPanel groupRadio=new JPanel(new GridLayout(0, 1, 0, 5));
        groupRadio.setBorder(BorderFactory.createTitledBorder("Тип двигателя"));


        dis.setSelected(true);
        ButtonGroup bt = new ButtonGroup();
        bt.add(dis);
        bt.add(icEng);
        bt.add(jetEng);


        groupRadio.add(dis);
        groupRadio.add(icEng);
        groupRadio.add(jetEng);
        addEngineButton.addActionListener(e -> {
            int fuel = 0, price = 0, rashod = 0;
            String name = "";
            try {
                fuel = Integer.parseInt(txtfuel.getText());
                name = txtname.getText();
                price = Integer.parseInt(txtprice.getText());
                rashod = Integer.parseInt(txtrashodTopliva.getText());
            } catch (Exception ex) {
            }
            if (dis.isSelected()) {
                eng = new Diesel(fuel, name, rashod, price);
            } else if (jetEng.isSelected()) {
                eng = new JetEngine(fuel, name, rashod, price);
            } else if (icEng.isSelected()) {
                eng = new ICEngine(fuel, name, rashod, price);
            }
            dispose();

        });

        CloseAddPanelButton.addActionListener(e->{
            dispose();
        });

        //Расставляем компоненты по местам

        add(groupRadio);
        add(txtfields);
        add(addEngineButton);
        add(CloseAddPanelButton);

        setVisible(true);


    }

    public Engine ret(){
        return eng;
    }

}
