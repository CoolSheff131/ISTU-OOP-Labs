package CLASSES;

public class JetEngine extends Engine{
    public JetEngine(){
        this.fuel=100;
        this.rashodTopliva=30;
        this.name="Двигатель реактивный";
        this.price=100000;
    }
    public JetEngine(int fuel,String name,int rashodTopliva,int price){
        this.fuel=fuel;
        this.rashodTopliva=rashodTopliva;
        this.name=name;
        this.price=price;
    }
    @Override
    public void start() {
        firstTact();
        System.out.println("топливо кончилось");
    }

    private void firstTact(){//вентилятор
        System.out.println("Воздух засосен");
        secondTact();
    }
    private void secondTact(){//камера сгорания
        if (fuel<=0)
        return;
        fuel-=rashodTopliva;
        System.out.println("Воздух воспламенился");
        thirdTact();
    }
    protected void thirdTact(){//сопло
        System.out.println("Воздух вышел");
        firstTact();
    }

    @Override
    public String toString() {
        return "Тип двигателя: турбореактивный двигатель\nИмя двигателя: "+name+"\nРасход топлива: "+rashodTopliva+"\nЦена: "+price;
    }
}
