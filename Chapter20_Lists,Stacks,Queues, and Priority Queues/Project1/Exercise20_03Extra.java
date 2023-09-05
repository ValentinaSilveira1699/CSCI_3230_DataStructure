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
