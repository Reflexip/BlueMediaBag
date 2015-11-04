package bluemediabag.displays;
//Imports-------------------------------------------------------
import bluemediabag.data.Bag;
import bluemediabag.data.Product;
import bluemediabag.data.ShopProductBase;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public final class Display {
//Fields--------------------------------------------------------
    private String choice = "";   
    private final Scanner input = new Scanner(System.in);
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    
//Constructor---------------------------------------------------
    public Display(ShopProductBase prodBase, Bag bag){
        chooseProduct(prodBase.getProductBase(), bag);        
    }
       
//Methods-------------------------------------------------------
    
   /*
    Main method. Its show first view where user:
    - choose products to buy, 
    - watch own shopping bag,
    - finish shopping and print bill.
    */
   public void chooseProduct(ArrayList<Product> productsBase, Bag bag){
       System.out.println("Hello customer! Choice your products by write product name.\n");
       
        do{            
            productsView(productsBase);
            choice = input.nextLine().toLowerCase();
            
            if(choice.equalsIgnoreCase("show")){
                new BagDisplay(bag);                               
            }
            else if(choice.equalsIgnoreCase("buy")){
                new BillPrinter(bag);
                break;            
            }
            else if(choice.equalsIgnoreCase("remove")){
                System.out.println("Which one you want to remove?");
                choice = input.nextLine().toLowerCase();
                bag.removeProduct(choice);                
            }
            else{
                bag.addProduct(productsBase, choice);
            }
        }while(!choice.equalsIgnoreCase("exit"));        
    }
    
    /*
    Method show all shop products with descripiton and price.
    */
    public void productsView(ArrayList<Product> productsBase){
        
        System.out.println("-------------------------------------------------------------------------");
        for(Product prod : productsBase){           
                System.out.println(prod.getName() + " - " + 
                                   prod.getDescription() + "\nPrice: " + 
                                   prod.getPrice() + "\n");
        }
        System.out.println("Comands:\n'show' - show your shopping bag\n'buy' - finish shopping and print your bill\n'remove' - remove product from your shopping bag\n'exit' - exit application\n");
        System.out.println("-------------------------------------------------------------------------");
    }  
}