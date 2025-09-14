// File: maxproduct152.java
import java.util.*;

class maxproduct152 {
    // Calculates the maximum product subarray
    public int maxProduct512(int[] nums) {
        int m = Integer.MIN_VALUE;
        int pre = 1;
        int suf = 1;
        int l = nums.length;

        for (int i = 0; i < l; i++) {
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;
            pre = pre * nums[i];
            suf = suf * nums[l - i - 1];
            m = Math.max(m, Math.max(suf, pre));
        }
        return m;
    }
    public static void main(String[] args) {
        maxproduct152 solution = new maxproduct152();

        // Test case 1: Positive and negative numbers
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Test Case 1: " + solution.maxProduct512(nums1)); // Expected output: 6

        // Test case 2: All negative numbers
        int[] nums2 = {-2, -3, -1};
        System.out.println("Test Case 2: " + solution.maxProduct512(nums2)); // Expected output: 6

        // Test case 3: Contains zero
        int[] nums3 = {-2, 0, -1};
        System.out.println("Test Case 3: " + solution.maxProduct512(nums3)); // Expected output: 0

        // Test case 4: Single element
        int[] nums4 = {5};
        System.out.println("Test Case 4: " + solution.maxProduct512(nums4)); // Expected output: 5

        // Test case 5: Large array with mixed values
        int[] nums5 = {2, -5, -2, -4, 3};
        System.out.println("Test Case 5: " + solution.maxProduct512(nums5)); // Expected output: 240
    }
}
