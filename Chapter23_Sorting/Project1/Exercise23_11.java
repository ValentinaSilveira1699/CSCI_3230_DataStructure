/*
(Heap clone and equals)
Use the template at https://liveexample.pearsoncmg.com/test/Exercise23_11_13e.txt to implement the clone and equals methods in the Heap class.
Sample Run
heap1:6
heap2:6
equals? true
heap1:5
heap2:6
equals? false
Class Name: Exercise23_11
*/

public class Exercise23_11 {
    public static void main(String[] args) throws CloneNotSupportedException {
        String[] strings = { "red", "green", "purple", "orange", "yellow", "cyan" };
        Heap heap1 = new Heap(strings);
        Heap heap2 = (Heap) (heap1.clone());
        System.out.println("heap1: " + heap1.getSize());
        System.out.println("heap2: " + heap2.getSize());
        System.out.println("equals? " + heap1.equals(heap2));
        heap1.remove();
        System.out.println("heap1: " + heap1.getSize());
        System.out.println("heap2: " + heap2.getSize());
        System.out.println("equals? " + heap1.equals(heap2));
    }

    public static class Heap implements Cloneable {
        // Variables
        String[] str;
        int len;

        // Constructor
        public Heap(String[] strings) {
            // Set the element of Strings
            str = new String[strings.length];
            for (int i = 0; i < strings.length; i++) {
                str[i] = strings[i];
            }
            len = str.length;
        }

        // Clone method
        public Heap clone() throws CloneNotSupportedException {
            // clone code
            Heap cloned = (Heap) super.clone();
            return cloned;
        }

        public int getSize() {
            return len;
        }

        // Implement equal method
        public boolean equals(Heap h) {
            if (len != h.len) {
                return false;
            }
            for (String st : str) {
                if (!str.equals(h.str)) {
                    return false;
                }
            }
            return true;
        }

        public void remove() {
            if (len > 0) {
                str[len - 1] = null;
            }
            len = len - 1;
        }
    }
}                              