import java.util.Scanner;

public class Exercise18_17 {
	public static void main(String[] args) {
		// Creation of a Scanner
		Scanner input = new Scanner(System.in);

		// Ask the user to enter a string
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);

        char[] chars = s.replaceAll(" ", "").toCharArray();
        System.out.println(ch + " appears " + count(chars, ch) + " times ");
    }

    private static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    private static int count(char[] chars, char ch, int high) {

        int count = (chars[high] == ch) ? 1 : 0;

        if (high == 0)
            return count;
        else
            return count + count(chars, ch, high - 1);
    }

}