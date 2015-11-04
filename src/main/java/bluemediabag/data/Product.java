package bluemediabag.data;

public class Product {
    
//Fields---------------------------------------------
        private String name;
        private String description;
        private double price;
        private int amount = 0;
        
//Constructor----------------------------------------
        public Product(String name, String description, double price){
            this.name = name;
            this.description = description;
            this.price = price;
        }
        
//Getters and setters--------------------------------     
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setOpis(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getAmount() {
        return amount;
    }

    /*
        Method increment value of amount field
    */
    public void addOne(){
        this.amount++;
    }
    
    /*
        Method decrement value of amount field
    */
    public void removeOne(){
        this.amount--;
    }
   
}


