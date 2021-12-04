package individual_202.individual_202;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class CheckPrice implements CheckHandler {
	private CheckHandler nextStep;

	public void setNextStep(CheckHandler nextHandler) {
		this.nextStep = nextHandler;

	}

	public void check() {
		List<List<String>> inputList = ReadInput.inputList;
		try (PrintWriter pw = new PrintWriter("output.csv")) {
			StringBuilder sb = new StringBuilder();
			sb.append("Item Name,");
			sb.append("Quantity,");
			sb.append("Total Price");
			sb.append("\n");
			for (List<String> item : inputList) {
				String itemNam = item.get(0);
				int itemQuantity = Integer.parseInt(item.get(1));
				double price = itemQuantity * Inventory.items.get(itemNam).price;
//				System.out.println(price);
				sb.append(itemNam+",");
				sb.append(itemQuantity+",");
				sb.append(price);
				sb.append("\n");
			}
			pw.write(sb.toString());
		} catch (FileNotFoundException e) {
			System.out.println("file not found output");
		}
	}
}
