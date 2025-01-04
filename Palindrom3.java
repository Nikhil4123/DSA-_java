import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        // Map to store the first and last index of each character
        Map<Character, int[]> map = new HashMap<>();

        // Populate the map with the first and last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new int[]{i, i}); // Initialize with the first occurrence
            } else {
                map.get(c)[1] = i; // Update the last occurrence
            }
        }

        int ans = 0;

        // Process each character to count unique characters between first and last indices
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] indices = entry.getValue();
            int start = indices[0];
            int end = indices[1];

            // Skip if there are no characters between start and end
            if (end - start <= 1) {
                continue;
            }

            // Use a Set to count unique characters between start and end
            Set<Character> uniqueChars = new HashSet<>();
            for (int i = start + 1; i < end; i++) {
                uniqueChars.add(s.charAt(i));
            }

            // Add the count of unique characters to the answer
            ans += uniqueChars.size();
        }

        return ans;
    }
}

public class Palindrom3 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: General case with multiple palindromic subsequences
        System.out.println("Test Case 1: " + solution.countPalindromicSubsequence("aabca")); // Expected output: 3

        // Test Case 2: Single character (no palindromic subsequence possible)
        System.out.println("Test Case 2: " + solution.countPalindromicSubsequence("a")); // Expected output: 0

        // Test Case 3: All unique characters (no repeating characters)
        System.out.println("Test Case 3: " + solution.countPalindromicSubsequence("abc")); // Expected output: 0

        // Test Case 4: Entire string is a single character repeated
        System.out.println("Test Case 4: " + solution.countPalindromicSubsequence("aaaa")); // Expected output: 1

        // Test Case 5: Complex case with varying character distribution
        System.out.println("Test Case 5: " + solution.countPalindromicSubsequence("abcba")); // Expected output: 4

        // Test Case 6: Edge case with no valid palindromic subsequences
        System.out.println("Test Case 6: " + solution.countPalindromicSubsequence("xyz")); // Expected output: 0

        // Test Case 7: Long string with mixed repeating characters
        System.out.println("Test Case 7: " + solution.countPalindromicSubsequence("abccbaabccba")); // Expected output: 12
    }
}
