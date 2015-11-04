package bluemediabag.data;
//Imports-------------------------------------------------------
import java.util.ArrayList;

public final class ShopProductBase {
//Fields-------------------------------------------------
    private ArrayList<Product> productBase;
    
//Constructor--------------------------------------------
    public ShopProductBase(){
        this.productBase = new ArrayList<>();
        addProducts();
    }
    
//Method-------------------------------------------------
    public void addProducts(){
        this.getProductBase().add(new Product("Cheese", "Edam cheese 250g", 4.90));
        this.getProductBase().add(new Product("Ham", "Pork Ham 400g", 9.99));
        this.getProductBase().add(new Product("Milk", "Cow milk 3.2%", 2.49));
        this.getProductBase().add(new Product("Cola", "Cola drink 500ml", 2.49));
        this.getProductBase().add(new Product("Sugar", "White sugar 500g", 2.99));
    }
    
//Getter-------------------------------------------------
    public ArrayList<Product> getProductBase() {
        return productBase;
    }
}
