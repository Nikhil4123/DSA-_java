package DailyProblems;

import java.util.*;

class DailyProblems {
    public long pickGifts(int[] g, int k) {
        // Create a max-heap to store the gifts in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : g)
            maxHeap.add(val);  // Add all the gift values to the max-heap

        // Perform the gift selection and modification process k times
        for (int i = 0; i < k && maxHeap.peek() > 1; i++) {
            int x = maxHeap.poll();  // Remove the largest gift
            maxHeap.add((int) Math.sqrt(x));  // Add the square root of the largest gift (rounded down to an integer)
        }

        // Calculate the sum of the remaining gifts in the max-heap
        long sum = 0;
        for (int val : maxHeap)
            sum += val;

        return sum;
    }

    // Test cases for the pickGifts method
    public static void main(String[] args) {
        DailyProblems solution = new DailyProblems();

        // Test case 1: Standard case with multiple gifts and k = 3
        int[] gifts1 = {16, 25, 36, 49, 64};
        int k1 = 3;
        // Explanation: After 3 operations, the gifts are modified as follows:
        // 1st operation: 64 -> sqrt(64) = 8 (maxHeap: {16, 25, 36, 49, 8})
        // 2nd operation: 49 -> sqrt(49) = 7 (maxHeap: {16, 25, 36, 7, 8})
        // 3rd operation: 36 -> sqrt(36) = 6 (maxHeap: {16, 25, 6, 7, 8})
        // Sum of remaining gifts = 16 + 25 + 6 + 7 + 8 = 156
        System.out.println("Test case 1 result: " + solution.pickGifts(gifts1, k1)); // Expected output: 156
        
        // Test case 2: Case with all small values (no change after taking square root)
        int[] gifts2 = {1, 1, 1, 1};
        int k2 = 2;
        // Explanation: Since all gifts are 1, taking the square root won't change them.
        // Sum of remaining gifts = 1 + 1 + 1 + 1 = 4
        System.out.println("Test case 2 result: " + solution.pickGifts(gifts2, k2)); // Expected output: 4
        
        // Test case 3: Case with large k and larger initial gifts
        int[] gifts3 = {100, 81, 64, 49, 36};
        int k3 = 5;
        // Explanation: After 5 operations, the gifts are modified as follows:
        // 1st operation: 100 -> sqrt(100) = 10 (maxHeap: {81, 64, 49, 36, 10})
        // 2nd operation: 81 -> sqrt(81) = 9 (maxHeap: {64, 49, 36, 10, 9})
        // 3rd operation: 64 -> sqrt(64) = 8 (maxHeap: {49, 36, 10, 9, 8})
        // 4th operation: 49 -> sqrt(49) = 7 (maxHeap: {36, 10, 9, 8, 7})
        // 5th operation: 36 -> sqrt(36) = 6 (maxHeap: {10, 9, 8, 7, 6})
        // Sum of remaining gifts = 10 + 9 + 8 + 7 + 6 = 39
        System.out.println("Test case 3 result: " + solution.pickGifts(gifts3, k3)); // Expected output: 39
        
        // Test case 4: Case with k = 0 (no change to gifts array)
        int[] gifts4 = {100, 25, 64};
        int k4 = 0;
        // Explanation: Since k = 0, no operations are performed.
        // Sum of remaining gifts = 100 + 25 + 64 = 189
        System.out.println("Test case 4 result: " + solution.pickGifts(gifts4, k4)); // Expected output: 189

        // Test case 5: Case with one large gift and k = 2
        int[] gifts5 = {1000};
        int k5 = 2;
        // Explanation: After 2 operations, the gift is modified as follows:
        // 1st operation: 1000 -> sqrt(1000) ≈ 31 (maxHeap: {31})
        // 2nd operation: 31 -> sqrt(31) ≈ 5 (maxHeap: {5})
        // Sum of remaining gifts = 5
        System.out.println("Test case 5 result: " + solution.pickGifts(gifts5, k5)); // Expected output: 5
    }
}

