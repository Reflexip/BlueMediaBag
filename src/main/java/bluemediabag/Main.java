package bluemediabag;
//Imports-------------------------------------------------------
import bluemediabag.data.ShopProductBase;
import bluemediabag.data.Bag;
import bluemediabag.displays.Display;

public class Main {
    
    public static void main(String[] args){
        Display display = new Display(new ShopProductBase(), new Bag());
    }
}

    

