package root.model.engines;

public abstract class Engine {

    // private <    void  <   protected <    public
    protected String type;
    protected String name;
    protected int fuel,rashodTopliva,price;
    public abstract void start();

    public String getName() {
        return name;
    }
    public int getFuel() {
        return fuel;
    }

    public int getRashodTopliva() {
        return rashodTopliva;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
