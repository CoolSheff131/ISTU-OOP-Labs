package root.control;

import root.View.*;
import root.Interfaces.InterfaceLoading;
import root.model.engines.Diesel;
import root.model.engines.Engine;
import root.model.engines.ICEngine;
import root.model.engines.JetEngine;
import root.model.ShopEngine;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Controller {
    private ArrayList<ItemListEng> alleng=new ArrayList<>();
    private boolean firstDel=true;
    private Engine eng;
    private Font f = new Font("Comic Sans MS", Font.PLAIN, 15);
    public Controller(){

    }
    public void execute(InterfaceLoading loading, ShopEngine shop, MainJFrame gr){
        gr.getChooseRemoveBotton().setEnabled(false);

        gr.getChooseAddButton().addActionListener((a)->{
            AddJDialog addMenu = new AddJDialog(gr);
            addMenu.getAddEngineButton().addActionListener(e -> {
                if(addMenu.getTxtfuel().getText().equals("")
                        ||addMenu.getTxtname().getText().equals("")
                        ||addMenu.getTxtprice().getText().equals("")
                        ||addMenu.getTxtrashodTopliva().getText().equals("")) {

                    return;
                }
                addMenu.dispose();
                int fuel = 0, price = 0, rashod = 0;
                String name = "";
                try {
                    fuel = Integer.parseInt(addMenu.getTxtfuel().getText());
                    name = addMenu.getTxtname().getText();
                    price = Integer.parseInt(addMenu.getTxtprice().getText());
                    rashod = Integer.parseInt(addMenu.getTxtrashodTopliva().getText());
                } catch (Exception ex) {
                }
                if (addMenu.getDis().isSelected()) {
                    eng = new Diesel(fuel, name, rashod, price);
                } else if (addMenu.getJetEng().isSelected()) {
                    eng = new JetEngine(fuel, name, rashod, price);
                } else if (addMenu.getIcEng().isSelected()) {
                    eng = new ICEngine(fuel, name, rashod, price);
                }



                if(eng!=null) {
                    addsEngToList(eng, gr, shop);
                    gr.getChooseRemoveBotton().setEnabled(true);
                }
            });
            addMenu.getCloseAddPanelButton().addActionListener(e->{
                addMenu.dispose();
            });

//            addMenu.setModal(true);
//            addMenu.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        });
        gr.getNameSearch().addActionListener((a)->{
            NameSearchJDialog nameSearch = new NameSearchJDialog(gr);
            nameSearch.getSearchB().addActionListener((A)-> {
                        eng = loading.getEngine(shop, nameSearch.getSearchNameField().getText());
                        nameSearch.getRes().removeAll();
                        if (eng != null){
                            ItemListEng res = new ItemListEng(eng, f);
                            nameSearch.getRes().add(res);
                            nameSearch.getRes().revalidate();
                            nameSearch.getRes().repaint();
                            nameSearch.getScrollPane().revalidate();
                        }else{
                            nameSearch.getRes().add(new Label("Двигатель не нашелся в магазине"));
                            nameSearch.getRes().revalidate();
                            nameSearch.getRes().repaint();
                            nameSearch.getScrollPane().revalidate();
                        }

            });
            nameSearch.getExitB().addActionListener((e)->{
                nameSearch.dispose();
            });
        });
        gr.getAdvanceSearch().addActionListener((a)->{
            SearchJDialog search = new SearchJDialog(gr);
            search.getClose().addActionListener(e -> {
                search.dispose();
            });
            search.getSearch().addActionListener(e -> {
                String stringDis = "";
                String stringICeng = "";
                String stringJeteng = "";
                if(search.getDis().isSelected())
                    stringDis ="Дизельный двигатель";
                if(search.getIceng().isSelected())
                    stringICeng ="Двигатель внутреннего сгорания";

                if(search.getJeteng().isSelected())
                    stringJeteng ="Реактивный двигатель";
                
                search.dispose();

                for (ItemListEng i:alleng )
                    i.setVisible(false);

                gr.getScrollPane().revalidate();
                if(!search.getNameField().getText().equals(""))
                for(int i=0;i<alleng.size();i++){
                    Engine eng = alleng.get(i).getEng();
                    if(     eng.getName().equals(search.getNameField().getText())
                            && (eng.getType().equals(stringDis)
                            || eng.getType().equals(stringICeng)
                            || eng.getType().equals(stringJeteng))
                            && eng.getFuel() >= Integer.parseInt(search.getMinFuel().getText())
                            && eng.getFuel() <= Integer.parseInt(search.getMaxFuel().getText())
                            && eng.getPrice() >= Integer.parseInt(search.getMinPrice().getText())
                            && eng.getPrice() <= Integer.parseInt(search.getMaxPrice().getText())
                            && eng.getRashodTopliva() >= Integer.parseInt(search.getMinRashod().getText())
                            && eng.getRashodTopliva() <= Integer.parseInt(search.getMaxRashod().getText())
                    ) alleng.get(i).setVisible(true);
                }
                else
                    for(int i=0;i<alleng.size();i++){

                        Engine eng = alleng.get(i).getEng();
                        if(     (eng.getType().equals(stringDis)
                                || eng.getType().equals(stringICeng)
                                || eng.getType().equals(stringJeteng))
                                && eng.getFuel() >= Integer.parseInt(search.getMinFuel().getText())
                                && eng.getFuel() <= Integer.parseInt(search.getMaxFuel().getText())
                                && eng.getPrice() >= Integer.parseInt(search.getMinPrice().getText())
                                && eng.getPrice() <= Integer.parseInt(search.getMaxPrice().getText())
                                && eng.getRashodTopliva() >= Integer.parseInt(search.getMinRashod().getText())
                                && eng.getRashodTopliva() <= Integer.parseInt(search.getMaxRashod().getText())
                        ) alleng.get(i).setVisible(true);

                    }
            gr.getShowAllEngine().setVisible(true);
            gr.getScrollPane().revalidate();
            });
        });
        gr.getChooseRemoveBotton().addActionListener((a)->{
            if(firstDel) {
                gr.getChooseRemoveBotton().setText("Удалить");
                for (ItemListEng i : alleng)
                    i.setDeletVisible(true);
                addAllEnginListToPanel(gr);
                firstDel=!firstDel;
                gr.getChooseCancelButton().setVisible(true);
            }else{

                for (int i=0;i<alleng.size();i++){
                    if(alleng.get(i).getDelet()){
                        shop.remove(alleng.get(i).getEng());
                        alleng.remove(i);
                        i--;
                    }
                }
                for (ItemListEng i : alleng)
                    i.setDeletVisible(false);
                addAllEnginListToPanel(gr);
                if(alleng.size()==0)
                    gr.getChooseRemoveBotton().setEnabled(false);
                gr.getChooseRemoveBotton().setText("Выбрать двигатели для удаления");
                gr.getChooseCancelButton().setVisible(false);
                firstDel=!firstDel;
            }

        });
        gr.getChooseCancelButton().addActionListener((a)->{
            gr.getChooseCancelButton().setVisible(false);
            firstDel = true;
            gr.getChooseRemoveBotton().setText("Выбрать двигатели для удаления");
            for (ItemListEng i : alleng)
                i.setDeletVisible(false);

        });
        gr.getShowAllEngine().addActionListener((a)->{
            for (ItemListEng i:alleng )
                i.setVisible(true);
            gr.getShowAllEngine().setVisible(false);
        });
        gr.getOpen().addActionListener(arg0 -> {

            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showOpenDialog(gr);
            if(ret == JFileChooser.APPROVE_OPTION){
                alleng.clear();
                shop.clearEng();
                File openedfile = fileopen.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(openedfile))){
                    String s;
                    while((s=br.readLine())!=null){
                        String type = s;
                        String name = br.readLine();
                        int fuel = Integer.parseInt(br.readLine());
                        int rashod = Integer.parseInt(br.readLine());
                        int price = Integer.parseInt(br.readLine());
                        switch (type){
                            case "Дизельный двигатель":             eng = new Diesel(fuel, name, rashod, price);break;
                            case "Двигатель внутреннего сгорания":  eng = new ICEngine(fuel, name, rashod, price); break;
                            case "Реактивный двигатель":            eng = new JetEngine(fuel, name, rashod, price); break;
                        }
                        if(eng!=null)
                            addsEngToList(eng,gr,shop);
                    }
                System.out.println ("Файл открылся и считался");
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден");
                } catch (IOException e) {
                    System.out.println("Ошибка открытия файла");
                } catch (Exception e){
                    JDialog err = new JDialog(gr,"Ошибка",true);
                    err.setSize(300,100);
                    JLabel badRead = new JLabel("Ошибка считывания файла");
                    badRead.setFont(f);
                    err.add(badRead);
                    err.setVisible(true);
                    System.out.println("Ошибка считывания файла");

                }
                if(alleng.size()!=0)
                    gr.getChooseRemoveBotton().setEnabled(true);
                else
                    gr.getChooseRemoveBotton().setEnabled(false);
            }


        });
        gr.getSave().addActionListener(arg0->{
            JFileChooser fileopen = new JFileChooser();
            int ret=fileopen.showSaveDialog(gr);
            if(ret==JFileChooser.APPROVE_OPTION){
                File openedfile = fileopen.getSelectedFile();

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(openedfile))){
                    for(Engine i: shop.getEngines()){
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
        gr.getSmallFont().addActionListener((a)->{
            f = new Font("Comic Sans MS", Font.PLAIN, 15);
            for(ItemListEng i:alleng)
                i.setMyFont(f);
        });
        gr.getNormalFont().addActionListener((a)->{
            f=new Font("Comic Sans MS", Font.PLAIN, 24);
            for(ItemListEng i:alleng)
                i.setMyFont(f);
        });
        gr.getBigFont().addActionListener((a)->{
            f=new Font("Comic Sans MS", Font.PLAIN, 33);
            for(ItemListEng i:alleng)
                i.setMyFont(f);
        });
    }
    //Добавляет все двигатели в списке на панель
    private void addAllEnginListToPanel(MainJFrame gr){
       gr.getAllEnginePanel().removeAll();
        for(ItemListEng i:alleng){
            gr.getAllEnginePanel().add(i);
            gr.getScrollPane().revalidate();
        }
        gr.getScrollPane().revalidate();
        gr.getScrollPane().repaint();
    }
    //Добавляет двигатель в список и магазин
    private void addsEngToList(Engine eng, MainJFrame gr, ShopEngine shop){
        alleng.add(new ItemListEng(eng,f));
        shop.add(eng);
        addAllEnginListToPanel(gr);

    }
}
