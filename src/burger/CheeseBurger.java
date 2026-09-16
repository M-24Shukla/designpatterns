package burger;

public class CheeseBurger implements IBurger {


    @Override 
    public void prepareBurger() {
        System.out.println("Preparing cheese burger");
    }
}
