package individual_202.individual_202;
import java.util.*;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.IOException;  

public class App {

    public static void main(String[] args) {
    
    	
    	CheckInventory check1= new CheckInventory();
    	CheckPrice check2= new CheckPrice();
    
    	check1.setNextStep(check2);
//    	System.out.println("Hello world");
    	
    	check1.check();

    	
    }
}
