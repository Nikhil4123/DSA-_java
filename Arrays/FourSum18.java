import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        List<List<Integer>> res = new ArrayList<>(); // Result list
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for i

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates for j

                int l = j + 1;
                int r = n - 1;

                while (l < r) {
                    long s = (long) nums[i] + nums[j] + nums[l] + nums[r]; // Handle overflow

                    if (s == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r])); // Add quadruplet

                        while (l < r && nums[l] == nums[l + 1]) l++; // Skip duplicates for l
                        while (l < r && nums[r] == nums[r - 1]) r--; // Skip duplicates for r

                        l++;
                        r--;
                    } else if (s < target) {
                        l++; // Move left pointer forward
                    } else {
                        r--; // Move right pointer backward
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println("Test Case 1: " + fourSum(nums1, target1));

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println("Test Case 2: " + fourSum(nums2, target2));

        int[] nums3 = {-3, -1, 0, 2, 4, 5};
        int target3 = 2;
        System.out.println("Test Case 3: " + fourSum(nums3, target3));

        int[] nums4 = {0, 0, 0, 0};
        int target4 = 0;
        System.out.println("Test Case 4: " + fourSum(nums4, target4));
    }
}
