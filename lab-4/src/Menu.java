import CLASSES.Diesel;
import CLASSES.Engine;
import CLASSES.ICEngine;
import CLASSES.JetEngine;

import java.util.Scanner;

public class Menu {

    private static Scanner inp;
    private static Engine currentEng;
    public static void start(){
        inp=new Scanner(System.in);
        info();
        boolean go=true;
        do {
        switch (inp.nextInt()){
            case 1:add(); break;
            case 2:choose();break;
            case 3:remove(); break;
            case 4:show(); break;
            case 5:ShopEngine.showAll();break;
            case 6:go=false;break;
            default:
                System.out.println("ошибка");break;
        }info();
        }while(go);
    }
    private static void info(){
        System.out.println("1 Добавить двигатель в магазин\n" +
                "2 выбрать двигатель\n" +
                "3 Удалить выбранный двигатель из магазина\n" +
                "4 показать характеристики выбранного двигателя\n" +
                "5 показать характеристики всех двигателей\n" +
                "6 выйти");
    }
    private static void add(){
        System.out.println("Введите название двигателя");
        String name=inp.next();
        int fuel,rashodTopliva,price;
        System.out.println("Введите количество топлива двигателя");
        fuel=inp.nextInt();
        System.out.println("Введите расход топлива двигателя");
        rashodTopliva=inp.nextInt();
        System.out.println("Введите цену двигателя");
        price=inp.nextInt();
        System.out.println("Введите тип двигателя:\n" +
                "1 двигатель внутреннего сгорания\n" +
                "2 дизельный двигатель\n" +
                "3 турбореактивный двигатель");
        Engine eng=null;
        boolean fa=false;
        do {
        switch (inp.nextInt()){
            case 1:eng=new ICEngine(fuel,name,rashodTopliva,price); break;
            case 2:eng=new Diesel(fuel,name,rashodTopliva,price); break;
            case 3:eng=new JetEngine(fuel,name,rashodTopliva,price); break;
            default: fa=true;System.out.println("Ошибка");break;
        }
        }while(fa);
        ShopEngine.add(eng);
    }
    private static void remove(){
        if(currentEng!=null)
        ShopEngine.remove(currentEng);
        else System.out.println("Двигатель не выбран");
    }
    private static void show(){
        if(currentEng!=null)
            ShopEngine.show(currentEng);
        else System.out.println("Двигатель не выбран");
    }
    private static void choose(){
        System.out.println("Введите название двигателя");
        currentEng = ShopEngine.search(inp.next());
        System.out.println("Двигатель выбран");
    }

}
