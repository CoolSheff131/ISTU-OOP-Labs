package root.View;

import javax.swing.*;
import java.awt.*;

public class NameSearchJDialog extends JDialog {
    private JTextField searchNameField;
    private JButton searchB;
    private JButton exitB;
    private JPanel res;
    private final JScrollPane scrollPane;

    public JTextField getSearchNameField() {
        return searchNameField;
    }

    public JButton getSearchB() {
        return searchB;
    }

    public JButton getExitB() {
        return exitB;
    }

    public JPanel getRes() {
        return res;
    }

    public JScrollPane getScrollPane() {return scrollPane;}

    public NameSearchJDialog(JFrame owner){
        super(owner,"Поиск по имени",false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(700, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        searchNameField = new JTextField();
        searchNameField.setColumns(10);
        searchB = new JButton("Поиск");
        exitB = new JButton("Выход");
        res = new JPanel();
        scrollPane = new JScrollPane(res);
        scrollPane.setPreferredSize(new Dimension(600,100));
        JPanel jij=new JPanel();
        jij.setLayout(new BoxLayout(jij,BoxLayout.Y_AXIS));
        jij.add(new Label("Результат"));
        jij.add(scrollPane);
        setResizable(false);
        add(searchB);
        add(exitB);
        add(searchNameField);
        add(jij);
        setVisible(true);
    }
}
