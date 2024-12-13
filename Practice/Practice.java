

import java.util.Arrays;

public class Practice {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 0; // Pointer to place unique numbers

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) { // Found a new unique number
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        return uniqueIndex + 1; // Length of the array with unique elements
    }

    public static void main(String[] args) {
        Practice solution = new Practice();

        // Test cases
        int[][] testCases = {
            {1, 1, 2, 3, 3, 4}, // Standard case with duplicates
            {1, 2, 3, 4, 5},    // No duplicates
            {},                 // Empty array
            {1, 1, 1, 1},       // All elements are the same
            {1},                // Single element array
            {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, // Larger array with duplicates
        };

        for (int[] testCase : testCases) {
            int length = solution.removeDuplicates(testCase);

            // Print results
            System.out.println("Original Array: " + Arrays.toString(testCase));
            System.out.println("Unique Count: " + length);
            System.out.print("Updated Array (Unique Elements): ");
            for (int i = 0; i < length; i++) {
                System.out.print(testCase[i] + " ");
            }
            System.out.println("\n");
        }
    }
}
