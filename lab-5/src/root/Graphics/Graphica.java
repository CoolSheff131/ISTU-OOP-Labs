package root.Graphics;

import root.CLASSES.Diesel;
import root.CLASSES.Engine;
import root.CLASSES.ICEngine;
import root.CLASSES.JetEngine;
import root.ShopEngine;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Graphica extends JFrame {

    private JDialog dialog;

    private ArrayList<ItemListEng> alleng=new ArrayList<>();
//компоненты главной

    private JPanel selectPanel;

    private JButton chooseAddButton;
    private JButton chooseRemoveBotton;
    private JButton chooseSearchButton;
    private JButton chooseCancelButton;
    private JButton showAllEngine;
    private JScrollPane scrollPane;
//компоненты добавления
    private Engine eng;
    private JPanel allEnginePanel;
    private boolean firstDel=true;

    public Graphica(){

        super("Магазин двигателей");
        setBounds(800,200,700,350);

        setMainPanel();
        addListeners();
        setMenubar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void setMenubar(){

        JMenuBar menuBar=new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createViewMenu());
        // Подключаем меню к интерфейсу приложения
        setJMenuBar(menuBar);

    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("Файл");
        JMenuItem open = new JMenuItem("Открыть");
        JMenuItem save = new JMenuItem("Сохранить");

        file.add(open);
        file.addSeparator();
        file.add(save);

        open.addActionListener(arg0 -> {

            JFileChooser fileopen =new JFileChooser();
            int ret=fileopen.showOpenDialog(Graphica.this);
            if(ret==JFileChooser.APPROVE_OPTION){
                alleng.clear();
                ShopEngine.clearEng();
                File openedfile = fileopen.getSelectedFile();
                try (BufferedReader br=new BufferedReader(new FileReader(openedfile))){
                    String s;
                    while((s=br.readLine())!=null){

                        String type = s;
                        String name = br.readLine();
                        int fuel = Integer.parseInt(br.readLine());
                        int rashod = Integer.parseInt(br.readLine());
                        int price = Integer.parseInt(br.readLine());

                        switch (type){
                            case "Дизельный двигатель":             eng= new Diesel(fuel, name, rashod, price);break;
                            case "Двигатель внутреннего сгорания":  eng=new ICEngine(fuel, name, rashod, price); break;
                            case "Реактивный двигатель":            eng=new JetEngine(fuel, name, rashod, price); break;
                        }
                        if(eng!=null)
                        addsEngToList(eng);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println ("ActionListener.actionPerformed : open");
        });

        save.addActionListener(arg0->{
            JFileChooser fileopen =new JFileChooser();
            int ret=fileopen.showSaveDialog(Graphica.this);
            if(ret==JFileChooser.APPROVE_OPTION){
                File openedfile = fileopen.getSelectedFile();

                try (BufferedWriter bw=new BufferedWriter(new FileWriter(openedfile))){
                    for(Engine i: ShopEngine.getEngines()){
                        bw.write(i.getType()+"\n");
                        bw.write(i.getName()+"\n");
                        bw.write(String.valueOf(i.getFuel())+"\n");
                        bw.write(String.valueOf(i.getRashodTopliva())+"\n");
                        bw.write(String.valueOf(i.getPrice())+"\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        return file;
    }

    private JMenu createViewMenu() {
        JMenu viewMenu = new JMenu("Вид");

        JCheckBoxMenuItem line  = new JCheckBoxMenuItem("Линейка");
        JCheckBoxMenuItem grid  = new JCheckBoxMenuItem("Сетка");
        JCheckBoxMenuItem navig = new JCheckBoxMenuItem("Навигация");

        JRadioButtonMenuItem one = new JRadioButtonMenuItem("Одна страница");
        JRadioButtonMenuItem two = new JRadioButtonMenuItem("Две страницы");

        ButtonGroup bg = new ButtonGroup();
        bg.add(one);
        bg.add(two);

        viewMenu.add(line);
        viewMenu.add(grid);
        viewMenu.add(navig);
        viewMenu.add( new JSeparator());
        viewMenu.add(one);
        viewMenu.add(two);

        return viewMenu;
    }

    private void setMainPanel(){

        Font f1 = new Font("Comic Sans MS", Font.BOLD, 40);
        JLabel kok=new JLabel("Магазин двигателей");
        kok.setFont(f1);

        selectPanel=new JPanel();
        allEnginePanel = new JPanel();
        allEnginePanel.setLayout(new BoxLayout(allEnginePanel,BoxLayout.Y_AXIS));

        chooseAddButton =new JButton("Добавить двигатель");
        chooseRemoveBotton=new JButton("Выбрать Убрать двигатель");
        chooseSearchButton=new JButton("Поиск двигателей");
        chooseCancelButton=new JButton("отмена");
        showAllEngine = new JButton("Показать все");

        chooseCancelButton.setVisible(false);
        showAllEngine.setVisible(false);

        chooseRemoveBotton.setEnabled(true);
        scrollPane=new JScrollPane(allEnginePanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.setPreferredSize(new Dimension(600,150));
        selectPanel.add(kok);
        JPanel jij=new JPanel();
        jij.setLayout(new BoxLayout(jij,BoxLayout.Y_AXIS));
        jij.add(new JLabel("Список двигателей"));
        jij.add(scrollPane);

        selectPanel.add(jij);

        selectPanel.add(chooseAddButton);
        selectPanel.add(chooseRemoveBotton);
        selectPanel.add(chooseCancelButton);
        selectPanel.add(chooseSearchButton);
        selectPanel.add(showAllEngine);
        selectPanel.setVisible(true);

        add(selectPanel, BorderLayout.CENTER);
    }

    private void addsEngToList(Engine eng){
        alleng.add(new ItemListEng(eng));
        ShopEngine.add(eng);
        addAllEnginListToPanel();

    }
    private void addAllEnginListToPanel(){
        allEnginePanel.removeAll();
        for(ItemListEng i:alleng){
        allEnginePanel.add(i);
        scrollPane.revalidate();
        }
    }
    private void addOneItemToPanel(ItemListEng item){
        allEnginePanel.add(item);
        scrollPane.revalidate();
    }

    private void addListeners(){

        chooseAddButton.addActionListener((a)->{
            AddJDialog addMenu=new AddJDialog(this);
            Engine eng = addMenu.ret();
            if(eng!=null)
            addsEngToList(eng);
        });

        chooseSearchButton.addActionListener((a)->{
            SearchJDialog search=new SearchJDialog(this);
            String[] val = search.getVal();
            if(val!=null){
                System.out.println("qwe");
                allEnginePanel.removeAll();
            int maxFuel= Integer.parseInt(val[4]);
            int minFuel= Integer.parseInt(val[5]);
            int maxPrice= Integer.parseInt(val[6]);
            int minPrice= Integer.parseInt(val[7]);
            int maxRashod= Integer.parseInt(val[8]);
            int minRashod= Integer.parseInt(val[9]);
                for(int i=0;i<alleng.size();i++){
                Engine eng=alleng.get(i).getEng();
                if(     eng.getName().equals(val[0])
                        &&(eng.getType().equals(val[1])
                           ||eng.getType().equals(val[2])
                           ||eng.getType().equals(val[3]))
                        && eng.getFuel()>minFuel
                        && eng.getFuel()<maxFuel
                        && eng.getPrice()>minPrice
                        && eng.getPrice()<maxPrice
                        && eng.getRashodTopliva()>minRashod
                        && eng.getRashodTopliva()<maxRashod
                )
                {
                    addOneItemToPanel(alleng.get(i));
                    System.out.println("sas");
                }
                }
            }
            showAllEngine.setVisible(true);
                scrollPane.revalidate();
        });

        chooseRemoveBotton.addActionListener((a)->{
            if(firstDel) {
                chooseRemoveBotton.setText("Удалить");
                for (ItemListEng i : alleng)
                    i.setDeletVisible(true);
                addAllEnginListToPanel();
                firstDel=!firstDel;
                chooseCancelButton.setVisible(true);
            }else{

                for (int i=0;i<alleng.size();i++){
                    if(alleng.get(i).getDelet()){
                        ShopEngine.remove(alleng.get(i).getEng());
                        alleng.remove(i);
                        i--;
                    }
                }
                addAllEnginListToPanel();
                chooseRemoveBotton.setText("Выбрать двигатели для удаления");
                chooseCancelButton.setVisible(false);
                firstDel=!firstDel;
            }

        });
        chooseCancelButton.addActionListener((a)->{
            chooseCancelButton.setVisible(false);
            firstDel=true;
            chooseRemoveBotton.setText("Выбрать двигатели для удаления");
            for (ItemListEng i : alleng)
                i.setDeletVisible(false);
        });
        showAllEngine.addActionListener((a)->{
            addAllEnginListToPanel();
            showAllEngine.setVisible(false);
        });
    }
}
