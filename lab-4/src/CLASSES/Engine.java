package CLASSES;

public abstract class Engine {
    public String getName() {
        return name;
    }

    // private <    void  <   protected <    public
    protected String name;
    protected int fuel,rashodTopliva,price;
    public abstract void start();

}
