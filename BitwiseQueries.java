public class BitwiseQueries {

    /**
     * This method returns an array where each element is the maximum XOR value 
     * for each query from the input array nums, based on the maximumBit constraint.
     */
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xorr = nums[0];
        int maxXor = (1 << maximumBit) - 1;

        // XOR all elements in nums to get the XOR of the whole array
        for (int i = 1; i < n; i++) {
            xorr ^= nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = xorr ^ maxXor;
            xorr ^= nums[n - 1 - i];
        }

        return ans;
    }

    /**
     * This method returns an array where each element is the maximum AND value 
     * for each query from the input array nums.
     */
    public int[] getMaximumAnd(int[] nums) {
        int n = nums.length;
        int andd = nums[0];

        // AND all elements in nums to get the AND of the whole array
        for (int i = 1; i < n; i++) {
            andd &= nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = andd;
            andd &= ~nums[n - 1 - i];
        }

        return ans;
    }

    /**
     * This method returns an array where each element is the maximum OR value 
     * for each query from the input array nums.
     */
    public int[] getMaximumOr(int[] nums) {
        int n = nums.length;
        int orr = nums[0];

        // OR all elements in nums to get the OR of the whole array
        for (int i = 1; i < n; i++) {
            orr |= nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = orr;
            orr &= ~nums[n - 1 - i];
        }

        return ans;
    }

    public static void main(String[] args) {
        BitwiseQueries solution = new BitwiseQueries();
        int[] nums = {0, 1, 1, 3};
        int maximumBit = 2;

        // Get maximum XOR results
        int[] xorResult = solution.getMaximumXor(nums, maximumBit);
        System.out.print("Maximum XOR for each query: ");
        for (int value : xorResult) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Get maximum AND results
        int[] andResult = solution.getMaximumAnd(nums);
        System.out.print("Maximum AND for each query: ");
        for (int value : andResult) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Get maximum OR results
        int[] orResult = solution.getMaximumOr(nums);
        System.out.print("Maximum OR for each query: ");
        for (int value : orResult) {
            System.out.print(value + " ");
        }
    }
}
