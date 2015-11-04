package bluemediabag.data;

//Imports-------------------------------------------------------
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class Bag {
    
//Fields-----------------------------------------
    private ArrayList<Product> shoppingBag;
    private DateTime dateOfShopping;
    private double totalCost = 0.00;
    private int productCounter = 0;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    
//Constructor------------------------------------
    public Bag(){
        shoppingBag = new ArrayList<Product>();
        dateOfShopping = new DateTime();
    }
    
//Methods----------------------------------------    
    /*
    .
    Method check if product already in bag and if doesn't, add it.
    Method add price of this one to total cost.
    Use sleep method in try/catch block to comfortable display.
    .
    */
    public void addProduct(ArrayList<Product> productsBase, String choice){
        for(Product prod : productsBase){                           //Search and equals product with user choise
                    if(prod.getName().equalsIgnoreCase(choice)){
                        if(alreadyInBag(prod.getName())){
                            
                            prod.addOne();                            
                            this.productCounter++;
                            this.totalCost += prod.getPrice();
                            
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println("\n\nYou add " + prod.getName() + " to your shopping bag.");
                            System.out.println("Number of products: " + this.productCounter + " products.");
                            System.out.println("Your bill total cost: " + decimalFormat.format(this.totalCost) + "\n\n\n");
                            System.out.println("-------------------------------------------------------------------------");
                            
                            
                                try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
                        }
                        else{
                            this.shoppingBag.add(prod);
                            this.totalCost += prod.getPrice();
                            this.productCounter++;
                            
                            prod.addOne();
                            
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println("\n\nYou add " + prod.getName() + " to your shopping bag.");
                            System.out.println("Number of products: " + this.productCounter);
                            System.out.println("Your bill total cost: " + decimalFormat.format(this.totalCost) + "\n\n\n");
                            System.out.println("-------------------------------------------------------------------------");
                                try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
                        }
                    }      
        }
    } 
    
    /*
    .
    Method check if product already in bag, check its amount. If already exist 
    subtract its amount.
    .
    */
    public void removeProduct(String choice){
        for(Product prod : this.shoppingBag){
            if(prod.getName().equalsIgnoreCase(choice)){
                
                if(prod.getAmount() > 1){                    
                    prod.removeOne();
                    
                    this.totalCost -= prod.getPrice();
                    this.productCounter--;
                    
                    System.out.println("Product " + prod.getName() + " removed from your shopping bag.");                
                        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}                

                    break;
                }
                else if(prod.getAmount() == 1){
                    prod.removeOne();
                    
                    this.shoppingBag.remove(prod);
                    this.totalCost -= prod.getPrice();
                    this.productCounter--;
                    
                    System.out.println("Product " + prod.getName() + " removed from your shopping bag.");
                        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}                

                    break;
                }
            }
        }
    }
    /*
    .
    Method check if product already in bag, and return boolean type.
    .
    */
    public boolean alreadyInBag(String name){
        boolean alreadyInBag = false;
        for(Product prod : this.shoppingBag){
            if(prod.getName().equalsIgnoreCase(name)){
                alreadyInBag = true;
                break;
            }
            else alreadyInBag = false;
        }
        return alreadyInBag;
    }

//Getters and Setters----------------------------------
    
    //Access method to shoppingBag field
    public ArrayList<Product> getShoppingBag(){
        return shoppingBag;
    }
    //Access method to dateOfShopping field
    public DateTime getDateOfShopping() {
        return dateOfShopping;
    }
    //Access method to totalCost field
    public double getTotalCost(){
        return totalCost;
    }
    //Access method to productCounter field
    public int getProductCounter(){
        return productCounter;
    }
}

    

