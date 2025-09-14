import java.util.*;

// LeetCodeDailySolutions Class
public class nov12{

    // 1. **Problem 1: Minimum Absolute Difference in BST**  
    // Given the root of a Binary Search Tree (BST), return the minimum difference between 
    // the values of any two different nodes in the tree.
    private static int minDiff = Integer.MAX_VALUE;
    private static Integer prev = null;

    public static int minDiffInBST(TreeNode root) {
        if (root == null) return minDiff;
        minDiffInBST(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;
        minDiffInBST(root.right);
        return minDiff;
    }

    // 2. **Problem 2: Unique Paths**  
    // Find the number of unique paths from the top-left to the bottom-right in an `m x n` grid,
    // only moving right or down.
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 3. **Problem 3: Search in Rotated Sorted Array**  
    // Given a rotated sorted array `nums`, search for a target value.
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) { // Left sorted portion
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else { // Right sorted portion
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    // 4. **Problem 4: Merge Intervals**  
    // Merge overlapping intervals.
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    // 5. **Problem 5: Longest Consecutive Sequence**  
    // Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        // Test cases for each solution
        System.out.println("Minimum Difference in BST: " + minDiffInBST(new TreeNode(4, new TreeNode(2), new TreeNode(6))));
        System.out.println("Unique Paths (3x7 grid): " + uniquePaths(3, 7));
        System.out.println("Search in Rotated Array ([4,5,6,7,0,1,2], target=0): " + search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println("Merged Intervals: " + Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println("Longest Consecutive Sequence: " + longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}

// Additional helper TreeNode class for tree problems
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
