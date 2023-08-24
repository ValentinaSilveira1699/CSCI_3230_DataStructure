import java.util.Scanner;
import java.math.*;

public class Exercise18_01 {
	public static void main(String[] args) {
		// Creation of a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer of any size: "); //ask user for an integer
		String n = input.nextLine();

		// Display the factorial method
		System.out.println("Factorial of " + n + " is " 
			+ factorial(new BigInteger(n)));
	}

	// Retrun the factorial method for the specified number
	public static BigInteger factorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ONE; 
		else // Recursive Call
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
}