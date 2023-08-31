/*
(Maximum element in an array)
Implement the following method that returns the maximum element in an array.
public static <E extends Comparable<E>> E max (E[] list)
Write a test program that prompts the user to enter 10 integers and invokes this method to find the max.
Sample Run
Enter 10 integers: 3 4 12 7 3 4 5 6 4 7
The max number is 12
Class Name: Exercise19_05
*/

import java.util.Scanner;

public class Exercise19_05 {

    public static <E extends Comparable<E>> E max(E[] list) {
        E m = list[0];
        for(int i = 0; i < list.length; ++i) {
            if(list[i].compareTo(m) > 0) {
                m = list[i];
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        Integer arr[] = new Integer[10];
        for(int i =0 ; i < arr.length; ++i) {
            arr[i] = in.nextInt();
        }
        System.out.println("The max number is " + max(arr));
    }

}
