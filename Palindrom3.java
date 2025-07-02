import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
=        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new int[]{i, i}); 
            } else {
                map.get(c)[1] = i; 
            }
        }

        int ans = 0;

        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] indices = entry.getValue();
            int start = indices[0];
            int end = indices[1];

            if (end - start <= 1) {
                continue;
            }

            Set<Character> uniqueChars = new HashSet<>();
            for (int i = start + 1; i < end; i++) {
                uniqueChars.add(s.charAt(i));
            }

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
