import java.util.Scanner;

public class Exercise18_21 {
	public static void main(String[] args) {
		// Creation of a Scanner
		Scanner input = new Scanner(System.in);

		// Ask the user to enter a decimal integer
		System.out.print("Enter a decimal integer: ");
		int value = input.nextInt();

		// Display the value's binary equivalent
		System.out.println(value + " decimal is binary " + dec2Bin(value));
	}

	// Methods that converts a decimal integer
	// into a binary integer as a string
	public static String dec2Bin(int value) {
		String result = "";
		return dec2Bin(value, result);
	}

	/** Recursive helper method */
	public static String dec2Bin(int value, String result) {
		if (value / 2 == 0) // Base case
			return (value % 2) + result;
		else
			return dec2Bin(value / 2, (value % 2) + result); // Recursive call
	}
}