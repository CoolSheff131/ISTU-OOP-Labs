package root.CLASSES;

//Internal combustion Engine
public class ICEngine extends Engine {


    public ICEngine(int fuel,String name,int rashodToppliva,int price){

        this.name=name;
        this.fuel=fuel;
        this.rashodTopliva=rashodToppliva;
        this.price=price;
        type="Двигатель внутреннего сгорания";
    }
    public ICEngine(){
        this.fuel=100;
        this.rashodTopliva=15;
        this.name="Без имени";
        this.price=1000;
        type="Двигатель внутреннего сгорания";
    }
    @Override
    public void start() {
        firstTact();
        System.out.println("топливо кончилось");
    }
    protected void firstTact(){//всасывание топлива и воздуха \\дизель тока воздух
        if(fuel<=0)
            return;
        fuel-=rashodTopliva;
        System.out.print("1 ");//"Топливо и воздух добавлено"
        secondTact();
    }
    protected void secondTact(){//сжатие воздуха
        System.out.print("2 ");//"Топливо и воздух сжаты"
        thirdTact();
    }
    protected void thirdTact(){//воспламенение искрой\\в дизеле силой сжатия
        System.out.print("3 ");//"Топливо и воздух зажглись при помощи свечи"
        fourthTact();
    }
    protected void fourthTact(){//выхлоп
        System.out.print("4\n");//"Выпуск отработанных газов"
        firstTact();
    }
    @Override
    public String toString() {
        return "Тип двигателя: Двигатель внутреннего сгорания\nИмя двигателя: "+name+"\nРасход топлива: "+rashodTopliva+"\nЦена: "+price;
    }
}
