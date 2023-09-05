/*
(Perform set operations on priority queues)
Use the template at https://liveexample.pearsoncmg.com/test/Exercise20_03Extra.txt to write a program that creates two priority queues for integers. Prompt the user to enter two lines of integers. Read each line of integers as a string and extract the integers from the string and add the integers to the two queues, respectively. Display their union, difference, and intersection. Note that the priority queue can have duplicates. The union of two priority queues may have duplicates. Display all output in increasing order.
Here is a sample run:
Enter integers for priority queue 1: 1 9 2 30 21 4 1
Enter integers for priority queue 2: 12 19 2 10 12 1
The union of the two priority queues is 
1 1 1 2 2 4 9 10 12 12 19 21 30 
The difference of the two priority queues is 
4 9 21 30 
The intersection of the two priority queues is 
1 1 2
Use the Collection interface’s addAll, removeAll, and retainAll methods to perforn union, difference, and intersection. 
Class Name: Exercise20_03Extra
*/
import java.util.*;

public class Exercise20_03Extra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create two priority queues for integers
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();

        // Prompt the user to enter integers for priority queue 1
        System.out.print("Enter integers for priority queue 1: ");
        String line1 = input.nextLine();
        String[] tokens1 = line1.split(" ");
        for (String token : tokens1) {
            int num = Integer.parseInt(token);
            queue1.offer(num);
        }

        // Prompt the user to enter integers for priority queue 2
        System.out.print("Enter integers for priority queue 2: ");
        String line2 = input.nextLine();
        String[] tokens2 = line2.split(" ");
        for (String token : tokens2) {
            int num = Integer.parseInt(token);
            queue2.offer(num);
        }

        // Create copies of the queues for set operations
        PriorityQueue<Integer> unionQueue = new PriorityQueue<>(queue1);
        PriorityQueue<Integer> differenceQueue = new PriorityQueue<>(queue1);
        PriorityQueue<Integer> intersectionQueue = new PriorityQueue<>(queue1);

        // Perform union, difference, and intersection using Collection methods
        unionQueue.addAll(queue2);
        differenceQueue.removeAll(queue2);
        intersectionQueue.retainAll(queue2);

        // Display the results in increasing order
        System.out.println("The union of the two priority queues is");
        while (!unionQueue.isEmpty()) {
            System.out.print(unionQueue.poll() + " ");
        }
        System.out.println();

        System.out.println("The difference of the two priority queues is");
        while (!differenceQueue.isEmpty()) {
            System.out.print(differenceQueue.poll() + " ");
        }
        System.out.println();

        System.out.println("The intersection of the two priority queues is");
        while (!intersectionQueue.isEmpty()) {
            System.out.print(intersectionQueue.poll() + " ");
        }
    }
}
