import java.util.HashSet;

public class SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> h = new HashSet<>();
        int left = 0;
        int maxi = 0;

        for (int right = 0; right < s.length(); right++) {
            while (h.contains(s.charAt(right))) {
                h.remove(s.charAt(left));
                left++;
            }
            h.add(s.charAt(right));
            maxi = Math.max(maxi, right - left + 1);
        }
        return maxi;
    }

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();

        // Test Case 1: Simple Case
        String test1 = "abcabcbb";
        System.out.println("Test 1: " + slidingWindow.lengthOfLongestSubstring(test1)); // Output: 3

        // Test Case 2: All Unique Characters
        String test2 = "abcdef";
        System.out.println("Test 2: " + slidingWindow.lengthOfLongestSubstring(test2)); // Output: 6

        // Test Case 3: Repeated Characters
        String test3 = "bbbbbb";
        System.out.println("Test 3: " + slidingWindow.lengthOfLongestSubstring(test3)); // Output: 1

        // Test Case 4: Empty String
        String test4 = "";
        System.out.println("Test 4: " + slidingWindow.lengthOfLongestSubstring(test4)); // Output: 0

        // Test Case 5: Single Character
        String test5 = "a";
        System.out.println("Test 5: " + slidingWindow.lengthOfLongestSubstring(test5)); // Output: 1

        // Test Case 6: Mixed Case
        String test6 = "pwwkew";
        System.out.println("Test 6: " + slidingWindow.lengthOfLongestSubstring(test6)); // Output: 3

        // Test Case 7: Edge Case with Spaces
        String test7 = "a b c d";
        System.out.println("Test 7: " + slidingWindow.lengthOfLongestSubstring(test7)); // Output: 5

        // Test Case 8: Numbers and Characters
        String test8 = "123abcd123";
        System.out.println("Test 8: " + slidingWindow.lengthOfLongestSubstring(test8)); // Output: 7
    }
}
