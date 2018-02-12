
import java.util.Scanner;

public class Credit {
	Scanner scan = new Scanner(System.in);	

	public Credit() {	
	} 
	
	public static void processCredCard(Scanner scan, long creditCardNumber, int expirationDate, int cvv, int debitCode, int debCred, String processed) {
		
		                           
		creditCardNumber = Validator.getLong(scan, "Please Enter your credit card number: \n");
		
		
		expirationDate = Validator.getInt(scan, "Please enter the experation date (0720): \n");
		
		cvv = Validator.getInt(scan, "Enter your CVV number: ");
		
		debCred = Validator.getInt(scan, "Well this be debit or credit? \n(Press 1 for Debit 2 for Credit)\n");
		
		if(debCred == 1) {
			
			debitCode = Validator.getInt(scan, "Please enter your 4 digit passcode\n");
			System.out.println("Processing your credit card.......\n");
		}
		else {
			System.out.println("Processing your credit card.........\n");
		}
		System.out.println("Thank you for your Purchase! Your Card has been processed.\n");
		
		return;
	}

}
