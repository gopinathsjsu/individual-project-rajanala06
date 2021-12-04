package individual_202.individual_202;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class ReadInput{
	static List<List<String>> inputList =  new ArrayList<>();
	
	public void readFile(String filePath) {
		String line = "";
		
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			br.readLine();
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] employee = line.split(",");
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(employee[0]);
				temp.add(employee[1]);
				temp.add(employee[2]);
				
				CardDetails.cards.add(employee[2]);
				inputList.add(temp);

			}
			
			System.out.println("Cards hashset");
			System.out.println(CardDetails.cards);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
