package root.View;

import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainJFrame extends JFrame {

    private JPanel selectPanel;
    private JButton chooseAddButton;
    private JButton chooseRemoveBotton;
    private JButton chooseCancelButton;
    private JButton showAllEngine;
    private JScrollPane scrollPane;
    private JPanel allEnginePanel;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem nameSearch;
    private JMenuItem advanceSearch;
    private JRadioButtonMenuItem bigFont;
    private JRadioButtonMenuItem normalFont;
    private JRadioButtonMenuItem smallFont;

    public JButton getChooseAddButton() {
        return chooseAddButton;
    }

    public JButton getChooseRemoveBotton() {
        return chooseRemoveBotton;
    }

    public JButton getChooseCancelButton() {
        return chooseCancelButton;
    }

    public JButton getShowAllEngine() {
        return showAllEngine;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JPanel getAllEnginePanel() {
        return allEnginePanel;
    }

    public JMenuItem getOpen() {
        return open;
    }

    public JMenuItem getSave() {
        return save;
    }

    public JMenuItem getNameSearch() {return nameSearch;}

    public JMenuItem getAdvanceSearch() {return advanceSearch;}

    public JRadioButtonMenuItem getBigFont() {return bigFont;}

    public JRadioButtonMenuItem getNormalFont() {return normalFont;}

    public JRadioButtonMenuItem getSmallFont() {return smallFont;}

    public MainJFrame(){

        super("Магазин двигателей");
        setBounds(800,200,700,350);
        setMainPanel();
        setMenubar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setMenubar(){
        JMenuBar menuBar=new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createViewMenu());
        menuBar.add(createSearchMenu());
        setJMenuBar(menuBar);
    }

    private JMenu createSearchMenu(){
        JMenu search = new JMenu("Поиск");
        nameSearch = new JMenuItem("Поиск");
        advanceSearch = new JMenuItem("Расширенный поиск");
        search.add(nameSearch);
        search.add(advanceSearch);
        return search;
    }
    private JMenu createFileMenu() {
        JMenu file = new JMenu("Файл");
        open = new JMenuItem("Открыть");
        save = new JMenuItem("Сохранить");
        file.add(open);
        file.addSeparator();
        file.add(save);
        return file;
    }



    private JMenu createViewMenu() {
        JMenu viewMenu = new JMenu("Вид");
        JMenu sizeFont = new JMenu("Размер Шрифта");
        smallFont = new JRadioButtonMenuItem("маленький");
        normalFont = new JRadioButtonMenuItem("Средний");
        bigFont = new JRadioButtonMenuItem("Большой");
        smallFont.setSelected(true);
        ButtonGroup bg =new ButtonGroup();
        bg.add(smallFont);
        bg.add(normalFont);
        bg.add(bigFont);
        setResizable(false);
        sizeFont.add(smallFont);
        sizeFont.add(normalFont);
        sizeFont.add(bigFont);
        viewMenu.add(sizeFont);
        return viewMenu;
    }

    private void setMainPanel(){

        Font f1 = new Font("Comic Sans MS", Font.BOLD, 40);
        JLabel kok = new JLabel("Магазин двигателей");
        kok.setFont(f1);

        selectPanel = new JPanel();
        allEnginePanel = new JPanel();
        allEnginePanel.setLayout(new BoxLayout(allEnginePanel,BoxLayout.Y_AXIS));

        chooseAddButton = new JButton("Добавить двигатель");
        chooseRemoveBotton = new JButton("Выбрать двигатели для удаления");

        chooseCancelButton = new JButton("отмена");
        showAllEngine = new JButton("Показать все");

        chooseCancelButton.setVisible(false);
        showAllEngine.setVisible(false);

        chooseRemoveBotton.setEnabled(true);
        scrollPane = new JScrollPane(allEnginePanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.setPreferredSize(new Dimension(600,150));
        selectPanel.add(kok);
        JPanel jij = new JPanel();
        jij.setLayout(new BoxLayout(jij,BoxLayout.Y_AXIS));
        jij.add(new JLabel("Список двигателей"));
        jij.add(scrollPane);

        selectPanel.add(jij);

        selectPanel.add(chooseAddButton);
        selectPanel.add(chooseRemoveBotton);
        selectPanel.add(chooseCancelButton);

        selectPanel.add(showAllEngine);
        selectPanel.setVisible(true);

        add(selectPanel, BorderLayout.CENTER);
    }


}
