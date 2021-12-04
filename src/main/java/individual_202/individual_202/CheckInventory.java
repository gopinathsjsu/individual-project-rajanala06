package individual_202.individual_202;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CheckInventory implements CheckHandler {
	
	private CheckHandler nextStep;
	public void setNextStep(CheckHandler nextHandler) {
		this.nextStep = nextHandler;
	}
	
	public void check() {
		Inventory i1 = Inventory.getInstance();
		i1.readDataset("Dataset - Sheet1.csv");
		boolean flag=false;
		boolean essflag=false;
		boolean luxflag=false;
		boolean miscflag=false;
						
		String quantflag="";
		
		HashMap<String, Item> dbitems = i1.items;
//		HashMap<String,Integer> a
		ReadInput r1 = new ReadInput();
		r1.readFile("Input3 - Sheet1.csv");
		List<List<String>> given = r1.inputList;
//		for(List<String> item:given) {
//			System.out.println(item);
//		}
//		System.out.println(dbitems.get("Milk"));
		int essentialQuantity=5;
		int luxuryQuantity=3;
		int miscQuantity=6;
		for (List<String> item: given) {
			double quantity = Double.parseDouble(item.get(1));
			String itemName = item.get(0);
			if(dbitems.get(itemName).quantity<quantity) {
				flag= true;
				quantflag+= "invalid quantity for "+itemName+" "+ item.get(1)+"\n";
			}
//			System.out.println(dbitems.get(itemName).category);
			switch(dbitems.get(itemName).category) {
			case "Essential":
				essentialQuantity-=quantity;
				
				if(essentialQuantity<0) {
					flag=true;
					essflag=true;
				}
				break;
				
			case "Luxury":
				luxuryQuantity-=quantity;
//				System.out.println(luxuryQuantity);
				if(luxuryQuantity<0) {
					flag=true;
					luxflag=true;
				}
				break;
				
			case "Misc":
				miscQuantity-=quantity;
				if(miscQuantity<0) {
					flag=true;
					miscflag=true;
				}
				break;
			default:
				break;
			}
		}
		/*System.out.println(flag || essflag || luxflag || miscflag);
		System.out.println("L flag"+ luxflag);*/
		if(flag || essflag || luxflag || miscflag) {
			try {
			      FileWriter myWriter = new FileWriter("errors.txt");
			      myWriter.write("Please correct quantities"+ "\n");
			      myWriter.write(quantflag);
			      if(quantflag.equals("")) {
			    	  if(essflag)
			    	  myWriter.write("Essentials reached to the cap"+ "\n");
			    	  if(luxflag)
				    	  myWriter.write("Luxury reached to the cap"+ "\n");
			    	  if(miscflag)
				    	  myWriter.write("Misc items reached to the cap"+ "\n");
			      }
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			return;
		}
	
		nextStep.check();
		
	}

	
}
