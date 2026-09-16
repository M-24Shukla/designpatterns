
/**
 * Usaage: PizzaProperties pizzaProperties = new PizzaProperties.PizzaBuilder().breadType("oats").cheeseType("mozzarela").toppings("paneer/red paprika").build();
 * PizzaProperties
 */

public class PizzaProperties {

    private final String breadType;

    private final String toppings;

    private final String cheeseType;

    private final String veggies;

    private final int size;

    private PizzaProperties(PizzaBuilder builder) {
        this.breadType = builder.breadType;
        this.toppings = builder.toppings;
        this.cheeseType = builder.cheeseType;
        this.veggies = builder.veggies;
        this.size = builder.size;
    }

    
    @Override
    public String toString() {
        return "PizzaProperties [breadType=" + breadType + ", toppings=" + toppings + ", cheeseType=" + cheeseType
                + ", veggies=" + veggies + ", size=" + size + "]";
    }

    public static class PizzaBuilder {

        private String breadType;
    
        private String toppings;
    
        private String cheeseType;
    
        private String veggies = "olive/jalepeno";
    
        private int size = 4;
    
        public PizzaBuilder breadType(String breadType) {
            this.breadType = breadType;
            return this;
        }

        public PizzaBuilder toppings(String breadType) {
            this.toppings = breadType;
            return this;
        }

        public PizzaBuilder cheeseType(String breadType) {
            this.cheeseType = breadType;
            return this;
        }

        
        public PizzaBuilder size(int breadType) {
            this.size = breadType;
            return this;
        }

        public PizzaProperties build() {
            return new PizzaProperties(this);
        }
    }

    
}
