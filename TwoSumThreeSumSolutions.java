// TwoSumThreeSumSolutions.java
import java.util.*;

public class TwoSumThreeSumSolutions {
    
    /**
     * 1. Two Sum
     * Given an array of integers `nums` and an integer `target`, 
     * return indices of the two numbers such that they add up to `target`.
     * Each input has exactly one solution, and we may not use the same element twice.
     * The solution is returned as an array of indices.
     */
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store the number and its index for quick lookup
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return indices of the two numbers
                return new int[] { map.get(complement), i };
            }

            // If complement not found, store the current number and its index in the map
            map.put(nums[i], i);
        }
        // Return an empty array if no solution is found (though problem guarantees a solution exists)
        return new int[0];
    }

    /**
     * 2. Two Sum II (Input Array is Sorted)
     * Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order,
     * find two numbers such that they add up to a specific target number. 
     * Return the indices of the two numbers in a 1-indexed array.
     */
    public int[] twoSumSorted(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        // Use two pointers starting from the beginning and end of the array
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Found the target, return indices (1-based indexing)
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                // If the sum is less than the target, move the left pointer to increase the sum
                left++;
            } else {
                // If the sum is greater than the target, move the right pointer to decrease the sum
                right--;
            }
        }
        // Return an empty array if no solution is found (though problem guarantees a solution exists)
        return new int[0];
    }

    /**
     * 3. Three Sum
     * Given an integer array `nums`, return all the unique triplets `[nums[i], nums[j], nums[k]]` 
     * such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.
     * The solution set must not contain duplicate triplets.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to use two-pointer technique
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets in the result
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // Add the triplet to the result if the sum equals target
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move left and right pointers to the next different numbers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both pointers inward
                    left++;
                    right--;
                } else if (sum < target) {
                    // If the sum is less than the target, move the left pointer to increase the sum
                    left++;
                } else {
                    // If the sum is greater than the target, move the right pointer to decrease the sum
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumThreeSumSolutions solver = new TwoSumThreeSumSolutions();
        
        // Test Two Sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Two Sum: " + Arrays.toString(solver.twoSum(nums, target)));

        // Test Two Sum II (Sorted)
        int[] sortedNumbers = {2, 3, 4, 6, 10};
        int sortedTarget = 10;
        System.out.println("Two Sum II (Sorted): " + Arrays.toString(solver.twoSumSorted(sortedNumbers, sortedTarget)));

        // Test Three Sum
        int[] numsForThreeSum = {-1, 0, 1, 2, -1, -4};
        System.out.println("Three Sum: " + solver.threeSum(numsForThreeSum));
    }
}
