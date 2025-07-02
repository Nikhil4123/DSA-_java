// StringBasics.java
// Basic string operations in Java

public class StringBasics {
    public static void main(String[] args) {
        String s = "hello world";
        // Print string
        System.out.println(s);
        // String length
        System.out.println("Length: " + s.length());
        // Reverse string
        String reversed = new StringBuilder(s).reverse().toString();
        System.out.println("Reversed: " + reversed);
    }
} 