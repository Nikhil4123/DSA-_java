import java.util.List;

public class LargestCombination {
    public int largestCombination(List<Integer> candidates) {
        int maxCount = 0;

        // Loop over each bit position (0 to 31)
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            // Count numbers with 1 at the current bit position
            for (int candidate : candidates) {
                if ((candidate & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Update maxCount if the current bit's count is higher
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        LargestCombination solution = new LargestCombination();
        List<Integer> candidates = List.of(16, 17, 71, 62, 12, 24, 14);
        
        int result = solution.largestCombination(candidates);
        System.out.println("The size of the largest subset with Bitwise AND > 0 is: " + result);
    }
}
