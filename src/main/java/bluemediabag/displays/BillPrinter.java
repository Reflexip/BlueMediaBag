package bluemediabag.displays;

import bluemediabag.data.Bag;
import bluemediabag.data.Product;
import java.text.DecimalFormat;


public class BillPrinter {
//Fields------------------------------------------
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");
    
//Constructor-------------------------------------
    public BillPrinter(Bag bag){        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\n\nSystem print your bill:\n");
        
        printTime(bag);
        printProducts(bag);
        printThanks();          //System print thanks for visit and invite to visit again
                                //sleep method with print simulates visit in shop
    }
    
//Methods------------------------------------------------------------------------
    /*
    Method print time of visit
    */
    public void printTime(Bag bag){
        System.out.println("Date of visit: " 
                                    + bag.getDateOfShopping().getDayOfMonth() + "/" 
                                    + bag.getDateOfShopping().getMonthOfYear() + "/" 
                                    + bag.getDateOfShopping().getYear());
        System.out.println("Time of visit: " 
                                    + bag.getDateOfShopping().getHourOfDay() + ":" 
                                    + bag.getDateOfShopping().getMinuteOfHour() + ":" 
                                    + bag.getDateOfShopping().getSecondOfMinute() + "\n");        
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
    }
    
    /*
    Method print amount, name and total price of each product and print total cost of bag
    */
    public void printProducts(Bag bag){
        for(Product prod : bag.getShoppingBag()){                               //Show each product in shopping bag
                System.out.println(prod.getAmount()                                 //and its amount and count price
                        + "x "                          
                        + prod.getName() + " = "                                    
                        + decimalFormat.format(prod.getAmount() * prod.getPrice()));
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        }
        System.out.println("Total cost: " + decimalFormat.format(bag.getTotalCost()));        
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
    }
    
    /*
    Method print thanks for visit
    */
    public void printThanks(){
        System.out.println("Thanks for visit.");
        
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        
        System.out.println("I hope to you visit our shop again. Bye!");
        
            try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("     /\\");
        System.out.println("    /  \\");
        System.out.println(" __/____\\__");
        System.out.println("|          |\n| YOUR BAG |\n|__________|");
        
    }
}