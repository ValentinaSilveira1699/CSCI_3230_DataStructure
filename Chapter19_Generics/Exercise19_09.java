/*
(Sort ArrayList)
Write the following method that sorts an ArrayList:
public static <E extends Comparable<E>> 
    void sort(ArrayList<E> list)
Write a test program that prompts the user to enter 10 integers, invokes this method to sort the numbers, and displays the numbers in increasing order.
Sample Run
Enter 10 integers: 3 4 12 7 3 4 5 6 4 7
The sorted numbers are 3 3 4 4 4 5 6 7 7 12
Class Name: Exercise19_09
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise19_09 {

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        E temp;
        for(int i = 0; i < list.size(); ++i) {
            for(int j = 0; j < list.size()-1; ++j) {
                if(list.get(j).compareTo(list.get(j+1)) > 0) {
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(in.nextInt());
        }
        sort(list);
        System.out.print("The sorted numbers are ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}