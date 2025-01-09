public class kthMissing1539 {
    public static void main(String[] args) {
        // Test cases
        Solution solution = new Solution();

        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        System.out.println("Test Case 1: " + solution.findKthPositive(arr1, k1)); // Output: 9

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 2;
        System.out.println("Test Case 2: " + solution.findKthPositive(arr2, k2)); // Output: 6

        int[] arr3 = {3, 6, 8, 10};
        int k3 = 4;
        System.out.println("Test Case 3: " + solution.findKthPositive(arr3, k3)); // Output: 5

        int[] arr4 = {1, 2, 3, 4, 5};
        int k4 = 1;
        System.out.println("Test Case 4: " + solution.findKthPositive(arr4, k4)); // Output: 6
    }
}

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0; // Counter for missing numbers
        int current = 1;     // Start checking from 1
        int index = 0;       // Pointer for the array
        
        while (missingCount < k) {
            // If the current number is missing
            if (index >= arr.length || arr[index] != current) {
                missingCount++; // Increment missing number count
                if (missingCount == k) {
                    return current; // Return when kth missing number is found
                }
            } else {
                index++; // Move to the next number in the array
            }
            current++; // Move to the next natural number
        }
        
        return -1; // Default return statement (should never reach here)
    }
}
