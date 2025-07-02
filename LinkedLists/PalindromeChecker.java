public class PalindromeChecker {

    // 1. Case-Insensitive, Alphanumeric-Only String Palindrome
    public static boolean isAlphanumericPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++; r--;
        }
        return true;
    }

    // 2. Case-Sensitive String Palindrome
    public static boolean isCaseSensitivePalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }

    // 3. Integer Palindrome
    public static boolean isIntegerPalindrome(int x) {
        if (x < 0) return false; // Negative numbers are not palindromes
        int original = x, reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }

    // 4. Linked List Palindrome
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean isLinkedListPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head, prev = null;

        // Find the middle of the linked list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // If odd number of elements, skip the middle node
        if (fast != null) slow = slow.next;

        // Compare the two halves
        while (prev != null && slow != null) {
            if (prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }

    // 5. Recursive Palindrome Check for String
    public static boolean isRecursivePalindrome(String s) {
        return checkRecursive(s, 0, s.length() - 1);
    }

    private static boolean checkRecursive(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return checkRecursive(s, l + 1, r - 1);
    }

    // Testing all methods
    public static void main(String[] args) {
        String testString = "A man, a plan, a canal: Panama";
        String testCaseSensitiveString = "madam";
        int testNumber = 12321;

        // Test 1: Alphanumeric-Only String Palindrome
        System.out.println("Alphanumeric Palindrome: " + isAlphanumericPalindrome(testString));

        // Test 2: Case-Sensitive String Palindrome
        System.out.println("Case-Sensitive Palindrome: " + isCaseSensitivePalindrome(testCaseSensitiveString));

        // Test 3: Integer Palindrome
        System.out.println("Integer Palindrome: " + isIntegerPalindrome(testNumber));

        // Test 4: Linked List Palindrome
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println("Linked List Palindrome: " + isLinkedListPalindrome(node1));

        // Test 5: Recursive String Palindrome
        System.out.println("Recursive Palindrome: " + isRecursivePalindrome("racecar"));
    }
}
