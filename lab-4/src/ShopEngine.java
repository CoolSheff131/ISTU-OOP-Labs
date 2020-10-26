import CLASSES.Engine;

import java.util.ArrayList;

public class ShopEngine {
    private static ArrayList<Engine> engines =new ArrayList<Engine>();
    public static void add(Engine A){
        try {
        engines.add(A);
            System.out.println("Двигатель добавлен в магазин");
        }catch (NullPointerException e){
            System.out.println("Неудалось добавить двигатель в магазин");
        }
    }
    public static void remove(Engine A){
        try {
            if(!engines.contains(A)){
                System.out.println("Двигателя нет в магазине");
                return;
            }

            engines.remove(A);
            System.out.println("Двигатель удален из магазина");
        }catch (NullPointerException e){
            System.out.println("Не удалось удалить двигатель");
        }
    }
    public static Engine search(String name){
        for (Engine i: engines) {
            if(name.equals(i.getName()))
                return i;
        }
        System.out.println("Двигатель не нашелся в магазине");
        return null;
    }
    public static void show(Engine A){
        if(A==null||!engines.contains(A)){
            System.out.println("Двигателя нету в магазине");
            return;
        }
        System.out.println("Характеристики двигателя:");
        System.out.println(A);
    }
    public static void showAll(){
        if (engines.size()>0)
        for (Engine i:engines) {
            System.out.println(i);
        }
        else
            System.out.println("Магазин пуст");
    }
}
