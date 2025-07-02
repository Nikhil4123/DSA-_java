import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class MajorityElementFinder {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int threshold = nums.length / 3;

        // Count occurrences of each number
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Check if any element occurs more than nums.length / 3 times
        for (Integer key : map.keySet()) {
            if (map.get(key) > threshold) {
                result.add(key);
            }
        }

        return result;
    }

    // Main method to run test cases
    public static void main(String[] args) {
        MajorityElementFinder finder = new MajorityElementFinder();

        // Test case 1: [3, 2, 3]
        int[] testCase1 = {3, 2, 3};
        System.out.println("Majority elements in test case 1: " + finder.findMajority(testCase1));

        // Test case 2: [1, 1, 1, 3, 3, 2, 2, 2]
        int[] testCase2 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Majority elements in test case 2: " + finder.findMajority(testCase2));

        // Test case 3: [1]
        int[] testCase3 = {1};
        System.out.println("Majority elements in test case 3: " + finder.findMajority(testCase3));

        // Test case 4: [1, 2, 3, 4]
        int[] testCase4 = {1, 2, 3, 4};
        System.out.println("Majority elements in test case 4: " + finder.findMajority(testCase4));

        // Test case 5: [1, 1, 1, 1, 2, 2]
        int[] testCase5 = {1, 1, 1, 1, 2, 2};
        System.out.println("Majority elements in test case 5: " + finder.findMajority(testCase5));
    }
}
