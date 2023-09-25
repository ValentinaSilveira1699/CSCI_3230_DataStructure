/*
(Pattern matching)
Write an O(n) program that prompts the user to enter two strings and tests whether the second string is a substring of the first string. Suppose the characters in the second string are distinct. (Don’t use the indexOf method in the String class.)
Sample Run 1
Enter a string s1: Welcome to Java
Enter a string s2: come
matched at index 3
Sample Run 2
Enter a string s1: Welcome to Java Java
Enter a string s2: Java
matched at index 11
Sample Run 3
Enter a string s1: Programming is fun
Enter a string s2: Java
No match
Class Name: Exercise22_03
*/

import java.util.*;

public class Exercise22_03 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two strings
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();

		int index = -1; // Stores index of s2 as a substring of s1
		int count = 0;  // Count matches

		// tests whether the second string is a substring of the first string
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0) && count == 0) {
				index = i;
				count++;
			}
			else if (s1.charAt(i) == s2.charAt(count)) {
				count++;
			}
			else {
				count = 0;
				index = -1;
			}

			if (count == s2.length())
				break;
		}

		// Display results
		if (index > 1)
			System.out.println("matched at index " + index);
		else
			System.out.println("string2 is not a substring of string1");
	}
}