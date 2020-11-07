package root.Graphics;

import root.CLASSES.Diesel;
import root.CLASSES.Engine;
import root.CLASSES.ICEngine;
import root.CLASSES.JetEngine;
import root.ShopEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class Graphica extends JFrame {

    private JDialog dialog;

//компоненты главной

    private JPanel selectPanel;

    private JButton chooseAddButton;
    private JButton chooseRemoveBotton;
    //private JButton chooseShowBotton;
    private JScrollPane scrollPane;
//компоненты добавления
    private Engine eng;
    private JPanel allEnginePanel;

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
        menuBar.add(createViewMenu());
        menuBar.add(createFileMenu());
        // Подключаем меню к интерфейсу приложения
        setJMenuBar(menuBar);

    }

    private JMenu createViewMenu() {
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

    private JMenu createFileMenu() {
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
        chooseRemoveBotton=new JButton("Убрать двигатель");
        //chooseShowBotton=new JButton("Показать двигатель");

        chooseRemoveBotton.setEnabled(false);

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
        //selectPanel.add(chooseShowBotton);
        selectPanel.setVisible(true);

        add(selectPanel, BorderLayout.CENTER);
    }

    private void addsEngToList(Engine eng){
        ItemListEng item=new ItemListEng(eng);
        allEnginePanel.add(item);
        ShopEngine.add(eng);
        scrollPane.revalidate();
    }
    private void addListeners(){

        chooseAddButton.addActionListener((a)->{
            AddMenu addMenu=new AddMenu(this);
            Engine eng = addMenu.ret();
            if(eng!=null)
            addsEngToList(eng);
        });

//        chooseShowBotton.addActionListener((a)->{
//            dialog = new JDialog(this,"Просмотр двигателей",true);
//            JTextArea     textArea=new JTextArea();
//            textArea.setText(ShopEngine.showAll());
//            dialog.add(textArea);
//            dialog.setSize(300,300);
//            dialog.setVisible(true);
//        });

        chooseRemoveBotton.addActionListener((a)->{
            scrollPane.revalidate();
            System.out.println("fjgh");
        });
    }
}
