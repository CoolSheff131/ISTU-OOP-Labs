package root.View;

import root.ActionListeners.NumbersOnlyKeyListener;
import root.model.engines.Diesel;
import root.model.engines.Engine;
import root.model.engines.ICEngine;
import root.model.engines.JetEngine;

import javax.swing.*;
import java.awt.*;

public class AddJDialog extends JDialog {

    private JTextField txtname;
    private JTextField txtfuel;
    private JTextField txtprice;
    private JTextField txtrashodTopliva;
    private JRadioButton dis;
    private JRadioButton icEng;
    private final JButton addEngineButton;
    private final JButton closeAddPanelButton;



    public JTextField getTxtname() {
        return txtname;
    }

    public JTextField getTxtfuel() {
        return txtfuel;
    }

    public JTextField getTxtprice() {
        return txtprice;
    }

    public JTextField getTxtrashodTopliva() {
        return txtrashodTopliva;
    }

    public JRadioButton getDis() {
        return dis;
    }

    public JRadioButton getIcEng() {
        return icEng;
    }

    public JRadioButton getJetEng() {
        return jetEng;
    }

    private JRadioButton jetEng;

    public JButton getAddEngineButton() {
        return addEngineButton;
    }

    public JButton getCloseAddPanelButton() {
        return closeAddPanelButton;
    }

    public AddJDialog(Frame owner){
        super(owner,"Добавить двигатель");

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(600, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addEngineButton = new JButton("Добавить Двигатель");
        closeAddPanelButton = new JButton("Отмена");

        JPanel txtfields=new JPanel(new GridLayout(2,4,10,10));
        txtname = new JTextField();
        txtfuel = new JTextField();
        txtprice = new JTextField();
        txtrashodTopliva = new JTextField();

        txtfuel.addKeyListener(new NumbersOnlyKeyListener(txtfuel));
        txtprice.addKeyListener(new NumbersOnlyKeyListener(txtprice));
        txtrashodTopliva.addKeyListener(new NumbersOnlyKeyListener(txtrashodTopliva));
        setResizable(false);
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

        dis=new JRadioButton("Дизельный двигатель");
        icEng=new JRadioButton("Двигатель внутреннего сгорания");
        jetEng=new JRadioButton("Турбо двигатель");
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
        add(groupRadio);
        add(txtfields);
        add(addEngineButton);
        add(closeAddPanelButton);
        setVisible(true);
    }

}
