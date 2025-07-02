// ArrayBasics.java
// Basic array operations in Java

public class ArrayBasics {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        // Print all elements
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        // Find sum
        int sum = 0;
        for (int num : arr) sum += num;
        System.out.println("Sum: " + sum);
    }
} 