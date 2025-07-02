class stringReverse {
    public void reverseString(char[] s) {
        int l = s.length - 1;
        int n = 0;
        while (n < l) {
            char c = s[n];
            s[n] = s[l];
            s[l] = c;
            n++;
            l--;
        }
    }

    public static void main(String[] args) {
        stringReverse obj = new stringReverse();
        
        // Test case
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        
        // Print original array
        System.out.println("Original String: " + new String(s));
        
        // Reverse the string
        obj.reverseString(s);
        
        // Print the reversed array
        System.out.println("Reversed String: " + new String(s));
    }
}
