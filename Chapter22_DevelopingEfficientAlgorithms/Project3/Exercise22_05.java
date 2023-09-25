/*
(Same-number subsequence)
Write an O(n) program that prompts the user to enter a sequence of integers ending with 0 and finds the longest subsequence with the same number.
Sample Run 1
Enter a series of numbers ending with 0:
2 4 4 8 8 8 8 2 4 4 0
The longest same number sequence starts at index 3 with 4 values of 8
Sample Run 2
Enter a series of numbers ending with 0: 34 4 5 4 3 5 5 3 2 0
The longest same number sequence starts at index 5 with 2 values of 5
Class Name: Exercise22_05
*/

import java.util.Scanner;

class Exercise22_05 {

public static void main(String[] args) {

// prompt user to enter numbers

System.out.print("Enter a series of numbers ending with 0: ");

// array of numbers of maximum size 1000

int[] numbers = new int[1000];

Scanner sc = new Scanner(System.in);

int n = 0;// number of integers entered

// while loop which exits when user enters 0

while (true) {

int now = sc.nextInt();

// if user enters 0

if (now == 0)

break;

numbers[n] = now;

n++;

}

// variables to compute given problem

int start = 0, end = 0, start_temp = 0, end_temp = 0;

// loop numbers array

for (int i = 1; i < n; i++) {

// if current number is equal to previous number then update temporary end

if (numbers[i] == numbers[end_temp]) {

end_temp = i;

} else {

// else if count of current number is greate than maximum count till now

if ((end - start) < (end_temp - start_temp)) {

// update start and end

start = start_temp;

end = end_temp;

}

// update start temp and end temp

start_temp = i;

end_temp = i;

}

}

// print output

System.out.println("The longest same number sequence starts at index " + start + " with " + (end - start + 1)

+ " values of " + numbers[start]);

}

}