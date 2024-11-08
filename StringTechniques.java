// Advanced String Techniques for DSA in Java
public class StringTechniques {

    // 1. Sliding Window Technique - Example: Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] charIndex = new int[128]; // Assuming ASCII
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            left = Math.max(charIndex[s.charAt(right)], left);
            maxLength = Math.max(maxLength, right - left + 1);
            charIndex[s.charAt(right)] = right + 1;
        }

        return maxLength;
    }

    // 2. Two Pointers Technique - Example: Valid Palindrome (ignoring non-alphanumeric characters)
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        
        return true;
    }

    // 3. KMP Algorithm - Example: Pattern Matching
    public int KMP(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return i - j; // Found match
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }

        return -1; // No match found
    }

    private int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0, i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                lps[i++] = ++length;
            } else if (length != 0) {
                length = lps[length - 1];
            } else {
                lps[i++] = 0;
            }
        }

        return lps;
    }

    // 4. Rabin-Karp Algorithm - Example: Pattern Matching with Hashing
    public int rabinKarp(String text, String pattern) {
        int prime = 101;
        int patternHash = createHash(pattern, pattern.length(), prime);
        int textHash = createHash(text, pattern.length(), prime);

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (patternHash == textHash && checkEqual(text, i, i + pattern.length(), pattern)) {
                return i; // Found match
            }

            if (i < text.length() - pattern.length()) {
                textHash = recalculateHash(text, i, i + pattern.length(), textHash, pattern.length(), prime);
            }
        }

        return -1;
    }

    private int createHash(String str, int end, int prime) {
        int hash = 0;
        for (int i = 0; i < end; i++) {
            hash += str.charAt(i) * Math.pow(prime, i);
        }
        return hash;
    }

    private int recalculateHash(String str, int oldIndex, int newIndex, int oldHash, int patternLen, int prime) {
        int newHash = oldHash - str.charAt(oldIndex);
        newHash /= prime;
        newHash += str.charAt(newIndex) * Math.pow(prime, patternLen - 1);
        return newHash;
    }

    private boolean checkEqual(String str, int start1, int end1, String pattern) {
        for (int i = start1, j = 0; i < end1; i++, j++) {
            if (str.charAt(i) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    // 5. Trie Data Structure - Example: Inserting and Searching for Words by Prefix
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }

    // 6. Dynamic Programming - Example: Longest Palindromic Subsequence
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    // 7. Bit Manipulation - Example: Checking for Unique Characters
    public boolean isUnique(String s) {
        int checker = 0;

        for (char c : s.toCharArray()) {
            int val = c - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }

        return true;
    }

    public static void main(String[] args) {
        StringTechniques st = new StringTechniques();
    
        // Test Sliding Window: Longest Substring Without Repeating Characters
        String test1 = "abcabcbb";
        int length1 = st.lengthOfLongestSubstring(test1);
        System.out.println("Longest substring without repeating characters in '" + test1 + "': " + length1); // Expected: 3 (abc)
    
        // Test Two Pointers: Valid Palindrome
        String test2 = "A man, a plan, a canal: Panama";
        boolean isPalindrome1 = st.isPalindrome(test2);
        System.out.println("Is '" + test2 + "' a palindrome? " + isPalindrome1); // Expected: true
    
        String test3 = "race a car";
        boolean isPalindrome2 = st.isPalindrome(test3);
        System.out.println("Is '" + test3 + "' a palindrome? " + isPalindrome2); // Expected: false
    
        // Test KMP Algorithm: Pattern Matching
        String text = "ababcabcabababd";
        String pattern = "ababd";
        int kmpIndex = st.KMP(text, pattern);
        System.out.println("KMP match index of pattern '" + pattern + "' in text: " + kmpIndex); // Expected: 10
    
        // Test Rabin-Karp Algorithm: Pattern Matching with Hashing
        String text2 = "hello world";
        String pattern2 = "world";
        int rabinKarpIndex = st.rabinKarp(text2, pattern2);
        System.out.println("Rabin-Karp match index of pattern '" + pattern2 + "' in text: " + rabinKarpIndex); // Expected: 6
    
        // Test Trie Data Structure: Insert and Search
        st.insert("hello");
        st.insert("helium");
        System.out.println("Search 'hello' in Trie: " + st.search("hello")); // Expected: true
        System.out.println("Search 'hel' in Trie: " + st.startsWith("hel")); // Expected: true
        System.out.println("Search 'world' in Trie: " + st.search("world")); // Expected: false
    
        // Test Dynamic Programming: Longest Palindromic Subsequence
        String test4 = "bbbab";
        int longestPalindromicSubseq = st.longestPalindromeSubseq(test4);
        System.out.println("Longest palindromic subsequence length in '" + test4 + "': " + longestPalindromicSubseq); // Expected: 4 (bbbb)
    
        // Test Bit Manipulation: Check Unique Characters
        String uniqueTest1 = "abcdef";
        boolean isUnique1 = st.isUnique(uniqueTest1);
        System.out.println("Is '" + uniqueTest1 + "' unique? " + isUnique1); // Expected: true
    
        String uniqueTest2 = "hello";
        boolean isUnique2 = st.isUnique(uniqueTest2);
        System.out.println("Is '" + uniqueTest2 + "' unique? " + isUnique2); // Expected: false
    }
    
}
