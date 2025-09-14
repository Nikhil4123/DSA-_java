// File: NeighboringBitwiseXOR.java
import java.util.*;

public class NeighboringBitwiseXOR {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] test1 = {1, 1, 0}; // Expected: true
        int[] test2 = {1, 0, 1}; // Expected: false
        int[] test3 = {0, 0, 0}; // Expected: true
        int[] test4 = {1, 1, 1, 1}; // Expected: true
        int[] test5 = {1, 0, 0, 1, 0}; // Expected: false

        // Running the tests
        System.out.println("Test 1: " + solution.doesValidArrayExist(test1));
        System.out.println("Test 2: " + solution.doesValidArrayExist(test2));
        System.out.println("Test 3: " + solution.doesValidArrayExist(test3));
        System.out.println("Test 4: " + solution.doesValidArrayExist(test4));
        System.out.println("Test 5: " + solution.doesValidArrayExist(test5));
    }
}

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int sum = 0;

        // XOR all elements of the derived array
        for (int num : derived) {
            sum ^= num;
        }

        // If sum == 0, the array is valid
        return sum == 0;
    }
}
