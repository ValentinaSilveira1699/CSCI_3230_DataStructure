import java.util.Scanner;

public class Exercise18_11 {
	public static void main(String[] args) {
		// Creation of a Scanner
		Scanner input = new Scanner(System.in);

		// Ask the user to enter an integer
		System.out.print("Enter an integer: ");
		long n = input.nextLong();

		// Display the sum
		System.out.println("The sum of digits in " + n + " is " + sumDigits(n));
	}

	// Method to sum the digits in an integer
	public static int sumDigits(long n) {
		return sumDigits(n, 0);
	}

	private static int sumDigits(long n, int sum) {
		if (n == 0)
			return sum;
		else // Recursive call
			return sumDigits(n / 10, sum + (int)(n % 10));
	}
}