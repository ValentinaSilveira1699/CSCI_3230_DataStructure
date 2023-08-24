import java.util.Scanner;

public class Exercise18_03 {

	public static void main(String[] args) {
		// Creation of a Scanner
		Scanner input = new Scanner(System.in);

		// Ask the user to enter two integers
		System.out.print("Enter the first number: ");
		int m = Integer.parseInt(input.next());
		System.out.print("Enter the second number: ");
		int n = Integer.parseInt(input.next());

		// Calucate and display the GCD
		System.out.println("The GCD of " + m + " and " + n 
			+ " is " + gcd(m, n));
	}

	// Method to calculate GCD
	private static int gcd(int m, int n) {
		if (m % n == 0)
			return n;
		else // Recursive call
			return gcd(n, m % n);
	}
}