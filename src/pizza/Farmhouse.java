package pizza;

public class Farmhouse implements IPizza{

    @Override 
    public void bake() {
        System.out.println("Baking farmhouse Pizza");
    }
}
