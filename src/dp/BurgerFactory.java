package dp;

import burger.CheeseBurger;
import burger.IBurger;
import burger.VegBurger;

public class BurgerFactory {

    public IBurger getBurger(String tpye) {
        String type = "cheese";
        IBurger burger;

        if(type.equals("veg")) {
            burger = new VegBurger();
        } else {
            burger = new CheeseBurger();
        }
        return burger;
    }
}
