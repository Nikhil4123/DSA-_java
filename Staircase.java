import java.io.*;

class Staircase {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as a parameter.
     */
    public static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // Print hashes
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println(); // Move to the next line
        }
    }

 

    public static void testCases() {
        System.out.println("Test Case 1: n = 1");
        staircase(1);
        System.out.println("\nTest Case 2: n = 3");
        staircase(3);
        System.out.println("\nTest Case 3: n = 5");
        staircase(5);
    }
}
