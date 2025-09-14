public class ManachersAlgorithm {

    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // Add special characters (#) to handle even-length palindromes
        String t = addBoundaries(s);
        int n = t.length();
        int[] p = new int[n]; // Array to store the radius of palindromes
        int center = 0, right = 0; // Current center and right boundary of the palindrome

        // Variables to track the longest palindrome
        int maxLen = 0, centerIndex = 0;

        for (int i = 0; i < n; i++) {
            // Check the mirrored index
            int mirror = 2 * center - i;

            // Use the previously computed values if within bounds
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Try to expand the palindrome centered at `i`
            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }

            // Update the center and right boundary if the palindrome expands
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Track the maximum palindrome length
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Extract the longest palindrome from the transformed string
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    // Add boundaries (#) to the string
    private static String addBoundaries(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append('#').append(c);
        }
        sb.append('#');
        return sb.toString();
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstring(s));
    }
}
