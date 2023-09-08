/*
(Perform set operations on tree sets)
Write a program as follows:
- Create two tree sets for strings using alphabetical order. 
- Prompt the user to enter two lines of strings. Strings are separated by spaces in a line.
- Extract the strings from the first/second line and add them to the first/second tree set, respectively.
- Display their union, difference, and intersection of the two tree sets. Use the set addAll, removeAll, and retainAll methods to perforn union, difference, and intersection.
(Hint: You can clone the sets to preserve the original sets from being changed by these set methods.)
Sample Run
Enter strings for the first set: Red Green Blue White Black Tan 
Enter strings for the second set: Red Orange Black Gray Pink 
The union of the two sets is [Black, Blue, Gray, Green, Orange, Pink, Red, Tan, White] 
The difference of the two sets is [Blue, Green, Tan, White] 
The intersection of the two sets is [Black, Red] 
Class Name: Exercise21_05Extra
*/

import java.util.*;

public class Exercise21_05Extra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create two TreeSet instances for strings
        TreeSet<String> set1 = new TreeSet<>();
        TreeSet<String> set2 = new TreeSet<>();

        // Prompt the user to enter two lines of strings
        System.out.print("Enter strings for the first set: ");
        String line1 = input.nextLine();
        System.out.print("Enter strings for the second set: ");
        String line2 = input.nextLine();

        // Extract strings from the first line and add them to set1
        String[] strings1 = line1.split(" ");
        set1.addAll(Arrays.asList(strings1));

        // Extract strings from the second line and add them to set2
        String[] strings2 = line2.split(" ");
        set2.addAll(Arrays.asList(strings2));

        // Clone the sets to preserve the original sets
        TreeSet<String> unionSet = new TreeSet<>(set1);
        TreeSet<String> differenceSet = new TreeSet<>(set1);
        TreeSet<String> intersectionSet = new TreeSet<>(set1);

        // Perform set operations
        unionSet.addAll(set2);          // Union
        differenceSet.removeAll(set2);  // Difference
        intersectionSet.retainAll(set2);// Intersection

        // Display the results
        System.out.println("The union of the two sets is " + unionSet);
        System.out.println("The difference of the two sets is " + differenceSet);
        System.out.println("The intersection of the two sets is " + intersectionSet);

        input.close();
    }
}
