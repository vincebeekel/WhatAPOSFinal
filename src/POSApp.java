import java.util.ArrayList;
import java.util.Scanner;



public class POSApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double wholeOrder;
		int anotherItem = 1;
		int cont = 0;
		double changeDue = 0.0;
		double paymentAmount = 0.0;
		double purchaseAmount = 0.0;
		int creditCardNumber = 0;
		int expirationDate = 0000;
		int cvv = 0;
		int debitCode = 0;
		int debCred = 0;
		String processed = "";
		int accountNumber = 0;
		int routingNumber = 0;
		int checkNumber = 0;
		int payMethod = 0;
		double wholeOrderTaxRate = 0.0;
		double taxRate = 1.06;

		int itemNum;
		System.out.println("Lets get Tipsy Party Store!");

		ArrayList<String> receiptArr = new ArrayList<>();
		ArrayList<Products> pList = FileMethods.readFromFile("product.txt");

		do {
			wholeOrder = 0.0;
			System.out.println("Check out your selection... ");

			do {

				System.out.println("______________________");

				int i = 0;

				//print product list from the product.txt file
				for (Products p : pList) {
					System.out.println(++i + ". " + p.getName() + ", " + p.getCategory() + ", " + p.getDescription()
							+ ", " + p.getPrice());
				}

				System.out.println(" ");
				
				//getting the customer to pick from the product list that was populated out by the plist array
				int pickItem = Validator.getInt(scan,
						"What would you like to purchase? \nPress the number for the corresponding item.\n", 1, i);
				//getting the item from the plist to be displayed on its own
				
				String name = pList.get(pickItem - 1).getName();
				String category = pList.get(pickItem - 1).getCategory();
				String description = pList.get(pickItem - 1).getDescription();
				String price = pList.get(pickItem - 1).getPrice();
				double priceDBL = Double.parseDouble(price);                //convert string into int
				
				//validating and check to see if user picked correct item
				int pickItemAnswer = Validator.getInt(scan,
						"Was this the item you picked? (enter 1 for yes or 2 for no) \n"+"---------------------\n" + name + ", " + category + ", "
								+ description + ", $" + price,
						1, 2);

				//populating the choice from the item the user picked.
				if (pickItemAnswer == 2) {
					System.out.println("\nOk, let's have another look at the list. ");
					continue;
				} else if (pickItemAnswer == 1) {

					//asking for quantity and getting a product total
					int numItems = Validator.getInt(scan, "\nHow many "+description +"'s of " + name + "'s would you like?");
					double productTotal = priceDBL * numItems;

					//print list and product total
						System.out.println("______________________");
					receiptArr.add(name + " X " + numItems + ": " + productTotal);

					//adding the product total throughout the loop.
					wholeOrder += productTotal;
					
					System.out.println("");

					//print out receipt 
					for (int j = 0; j < receiptArr.size(); j++) {
						System.out.println(receiptArr.get(j));
					}
					
					//to let the customer know how much the individual item costs
					System.out.printf("\nYour order so far is (not including tax) $%.2f", wholeOrder);
					System.out.println("");

					anotherItem = Validator.getInt(scan, "\nWould you like to purchase another item? (1=yes/2=no)\n____________________", 1,
							2);
				}
				
				//this is to display the list of items in their purchase
				for (int j = 0; j < receiptArr.size(); j++) {
					System.out.println(receiptArr.get(j));
				}

				//do while to keep adding another item to the purchase
			} while (anotherItem == 1);
			System.out.println("\n");
			
			//this give the customer a visual of what they are purchasing and how much their order is before buying
			taxRate = 1.06;
			wholeOrderTaxRate = wholeOrder * taxRate;
			System.out.printf("Your order is $%.2f", wholeOrder);
			System.out.printf(" with tax (6 percent) is $%.2f",(wholeOrderTaxRate));
			System.out.println("\n\n");

			// Pick Cash, check or credit
			
			int cashCheckCredit = Validator.getInt(scan,
					"What form of payments do you wish to use? \n\n press 1 for Cash / 2 for Credit / 3 for Check\n",
					1, 4);
			switch (cashCheckCredit) {
			case 1:
				Cash.makeChange(scan, changeDue, paymentAmount, wholeOrderTaxRate);
				break;
			case 2:
				Credit.processCredCard(scan, creditCardNumber, expirationDate, cvv, debitCode, debCred, processed);
				break;
			case 3:
				Check.checktingNumber(scan, accountNumber, routingNumber, checkNumber);
				break;
			}

			// print receipt
			
			System.out.println("\nThanks for coming in! \n");
			System.out.println("Here is your receipt \n___________________________");
			for (int j = 0; j < receiptArr.size(); j++) {
				System.out.println(receiptArr.get(j));
			}
			System.out.printf("\nYour order is $%.2f", wholeOrder);
			System.out.printf(" with tax (6 percent) is $%.2f",(wholeOrderTaxRate));
			System.out.println("\n\n");
			
			receiptArr.clear(); //clears receipt for next order

			//cont is the do while loop that allows the program to run another purchase
			cont = Validator.getInt(scan,
					"\nThank you for your business.\n\nWould you like to place another order? (1 for yes / 2 for no) \n");
		} while (cont == 1);


	}
}


