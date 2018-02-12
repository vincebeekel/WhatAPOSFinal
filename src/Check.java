
import java.util.Scanner;

public class Check  {
	
	public Check() {
		
	}
	
	public static void checktingNumber(Scanner scan, int accountNumber, int routingNumber, int checkNumber) {

		accountNumber = Validator.getInt(scan, "Please enter your Check Account number\n");
		
		routingNumber = Validator.getInt(scan, "Please enter your Routing Number\n");
		
		checkNumber = Validator.getInt(scan, "Please enter your Check Number\n");
		
		System.out.println("Thank you for your purchase, your check has been processed!\n");
		
		return;
		
	}
	

}
