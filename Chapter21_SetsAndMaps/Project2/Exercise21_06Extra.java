/*
(Count occurrences of characters)
Write a program that reads a string and counts the occurrences of each letter. The letters are case-insensitive. The program displays the letters and their corresponding count in increasing order of the count. If the two counts are equal, use the alphabetic order. The letters are displayed in lowercase. Here is a sample run:
Sample Run
Enter s string: Welcome to Java
c: 1
t: 1
v: 1
w: 1
j: 1
l: 1
m: 1
a: 2
e: 2
o: 2
Class Name: Exercise21_06Extra
*/
import java.util.*;
 
public class Exercise21_06Extra { 
  public static void main(String[] args) { 
    Scanner input = new Scanner(System.in); 
    System.out.print("Enter s string: "); 
    String line = input.nextLine();  
 
    // Create a TreeMap to hold characters as key and count as value
    Map<Character, Integer> map = new HashMap<>();
 
    for (int i = 0; i < line.length(); i++) {
      if (Character.isLetter(line.charAt(i))) {
        char key = Character.toLowerCase(line.charAt(i)); 
        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
      }
    }
 
    List<Map.Entry<Character, Integer>> entries = new 
      ArrayList<>(map.entrySet());
    Collections.sort(entries, (e1, e2) -> {
      if (e1.getValue() == e2.getValue()) // Equal count
        return e1.getValue() - e2.getValue(); 
      else
        return e1.getValue() - e2.getValue(); });
    
    // Display key and value for each entry in the list
    for (Map.Entry<Character, Integer> entry: entries)
      System.out.println(entry.getKey() + ": " + entry.getValue());
  }
}