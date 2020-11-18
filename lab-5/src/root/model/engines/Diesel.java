package root.model.engines;

public class Diesel extends ICEngine {


    public Diesel(){
        super(100,"ba",10,1000);
        type="Дизельный двигатель";
    }
    public Diesel(int fuel,String name,int rashodToppliva,int price){
        super(fuel,name,rashodToppliva,price);
        type="Дизельный двигатель";
    }

    @Override
    public void start() {
        firstTact();
        System.out.println("топливо кончилось");
    }

    @Override
    public void firstTact() {
        System.out.print("1 ");//"Воздух впущен"
        secondTact();
    }

    @Override
    protected void secondTact() {
        if(fuel<=0)
            return;
        fuel-=rashodTopliva;
        System.out.print("2 ");//"Воздух сжат впущен дизель"
        thirdTact();
    }

    @Override
    protected void thirdTact() {
        System.out.print("3 ");//"Поршень опускается вниз"
        super.fourthTact();
    }

    @Override
    public String toString() {
        return "Тип двигателя: дизельный двигатель\nИмя двигателя: "+name+"\nРасход топлива: "+rashodTopliva+"\nЦена: "+price;
    }
}
