
import java.util.Scanner;

public class Cash {
	
	public static double makeChange(Scanner scan,double changeDue, double paymentAmount, double wholeOrder) {
		
//		System.out.println("How much is your purchase");
//		purchaseAmount = scan.nextDouble();
		
//		wholeOrder = Validator.getDouble(scan, "How much is your purchase. ");
		
		
//		System.out.println("How much is your purchase");
//		paymentAmount = scan.nextDouble();
		
		paymentAmount = Validator.getDouble(scan, "Enter the amount of money you are playing with.\n");
		
		do {
			if (paymentAmount < wholeOrder) {
//				System.out.println("Please enter more money");
//				paymentAmount = scan.nextDouble();
				
				paymentAmount = Validator.getDouble(scan, "Nice Try! Don't try to short change us. You Must Enter more money!\n");
				
				changeDue = paymentAmount - wholeOrder;
				System.out.printf("Your change is $%.2f",  changeDue);
				System.out.println("");
				
			} else {
				changeDue = paymentAmount - wholeOrder;
				System.out.printf("Your change is $%.2f",  changeDue);
				System.out.println("");
			} 
		} while (paymentAmount < wholeOrder);
	
	
		return changeDue;	
	}

}
