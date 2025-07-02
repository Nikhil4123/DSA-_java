


import java.util.HashMap;

class sliding3 {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxFreq = 0; // To track the maximum frequency of any character in the window

        for (int r = 0; r < s.length(); r++) {
            // Update the frequency of the current character
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(r)));

            // Check if the current window is invalid
            while ((r - l + 1) - maxFreq > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++; // Shrink the window
            }

            // Update the result with the size of the valid window
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        sliding3 solution = new sliding3();

        // Test cases
        System.out.println(solution.characterReplacement("AABABBA", 1)); // Expected: 4
        System.out.println(solution.characterReplacement("ABAB", 2));    // Expected: 4
        System.out.println(solution.characterReplacement("AAAB", 0));   // Expected: 3
    }
}
