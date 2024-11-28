class mergestring {
    // Method 1: Using StringBuilder (Efficient and Easy to Understand)
    public String mergeAlternately(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();
        int n = 0, m = 0;
        StringBuilder sb = new StringBuilder();

        // Merge alternately
        while (n < a && m < b) {
            sb.append(word1.charAt(n));
            sb.append(word2.charAt(m));
            n++;
            m++;
        }

        // Add remaining characters from the longer string
        while (n < a) {
            sb.append(word1.charAt(n));
            n++;
        }
        while (m < b) {
            sb.append(word2.charAt(m));
            m++;
        }

        return sb.toString();
    }

    // Optimal Method: Using a Single Loop and Avoiding Additional Loops
    public String mergeAlternatelyOptimal(String word1, String word2) {
        int i = 0, j = 0;
        int len1 = word1.length(), len2 = word2.length();
        StringBuilder sb = new StringBuilder(len1 + len2);

        // Single loop for merging alternately and handling leftovers
        while (i < len1 || j < len2) {
            if (i < len1) sb.append(word1.charAt(i++));
            if (j < len2) sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }

    // Main method to test the functions
    public static void main(String[] args) {
        mergestring solution = new mergestring();

        // Test cases
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println("Merge Alternately: " + solution.mergeAlternately(word1, word2));
        System.out.println("Merge Alternately Optimal: " + solution.mergeAlternatelyOptimal(word1, word2));

        word1 = "ab";
        word2 = "pqrs";
        System.out.println("Merge Alternately: " + solution.mergeAlternately(word1, word2));
        System.out.println("Merge Alternately Optimal: " + solution.mergeAlternatelyOptimal(word1, word2));

        word1 = "abcd";
        word2 = "pq";
        System.out.println("Merge Alternately: " + solution.mergeAlternately(word1, word2));
        System.out.println("Merge Alternately Optimal: " + solution.mergeAlternatelyOptimal(word1, word2));
    }
}
