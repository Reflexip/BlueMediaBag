package bluemediabag.displays;

//Imports------------------------------------------------------------------------
import bluemediabag.data.Bag;
import bluemediabag.data.Product;
import java.text.DecimalFormat;

public class BagDisplay {
    
//Fields-------------------------------------------------------------------------
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");


//Constructor--------------------------------------------------------------------   
    public BagDisplay(Bag bag){        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\n\n\nYour shopping bag:\n");
        
        for(Product prod : bag.getShoppingBag()){
            System.out.println(prod.getAmount() 
                    + "x "                                                      //Show each product in shopping bag
                    + prod.getName() + " = "                                    //and its amount and count price
                    + decimalFormat.format(prod.getAmount() * prod.getPrice()));
        }
        showDetails(bag);
                System.out.println("-------------------------------------------------------------------------");                
                try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();} 
    }
    
//Methods------------------------------------------------------------------------    
    /*
    Method print number of products in bag and total cost.
    */
    public void showDetails(Bag bag){
            System.out.println("\nNumber of products: " + bag.getProductCounter());
            System.out.println("Total cost: " + bag.getTotalCost());
            System.out.println("\n\nAfter 3 seconds, you will be taken back to the shop.\n\n\n");
    }
}