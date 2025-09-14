public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the next larger element to swap with
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap the elements
            swap(nums, i, j);
        }

        // Step 3: Reverse the subarray to the right of the pivot
        reverse(nums, i + 1, n - 1);
    }

    // Helper function to swap two elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse a subarray
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();
        int[] nums = {1, 2, 3};
        sol.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
