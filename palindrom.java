package DSA;
/*
 * 
# Java String Basics

## A. String Declaration and Initialization
- **String Literal:**
  ```java
  String str = "Hello, World!";
  ```
- **String Object:**
  ```java
  String str = new String("Hello, World!");
  ```

## B. Common String Methods
- **Length of String:**
  ```java
  int length = str.length();
  ```
- **Character at Specific Index:**
  ```java
  char ch = str.charAt(0); // 'H'
  ```

## C. String Manipulation
- **Substring:**
  ```java
  String sub = str.substring(7, 12); // "World"
  ```
- **Concatenation:**
  ```java
  String concatStr = str + " Welcome!";
  // or
  String concatStr = str.concat(" Welcome!");
  ```

## D. String Comparison
- **Equality Check:**
  ```java
  boolean isEqual = str.equals("Hello, World!"); // true
  ```
- **Case-Insensitive Comparison:**
  ```java
  boolean isEqualIgnoreCase = str.equalsIgnoreCase("hello, world!"); // true
  ```

## E. String Search
- **Index of a Character or Substring:**
  ```java
  int index = str.indexOf("World"); // 7
  ```
- **Last Index of a Character or Substring:**
  ```java
  int lastIndex = str.lastIndexOf("o"); // 8
  ```

## F. String Replacement
- **Replace a Character:**
  ```java
  String replacedStr = str.replace('o', '0'); // "Hell0, W0rld!"
  ```
- **Replace Substring:**
  ```java
  String replacedSubstring = str.replace("World", "Java"); // "Hello, Java!"
  ```

## G. String Splitting
- **Split a String:**
  ```java
  String[] words = str.split(", "); // ["Hello", "World!"]
  ```

## H. String Trimming
- **Trim Whitespace:**
  ```java
  String trimmedStr = str.trim(); // Removes leading and trailing whitespace
  ```

## I. String Formatting
- **Formatted Output:**
  ```java
  String formattedStr = String.format("Hello, %s!", "World"); // "Hello, World!"
  ```

## J. Immutable Nature of Strings
- Strings are immutable in Java, meaning once a string is created, it cannot be changed. Any operation that modifies a string actually creates a new string.

## K. StringBuilder for Mutable Strings
- **Using StringBuilder:**
  ```java
  StringBuilder sb = new StringBuilder("Hello");
  sb.append(", World!"); // "Hello, World!"
  ```

## L. Conversion Between Types
- **Convert to String:**
  ```java
  int number = 10;
  String numberStr = String.valueOf(number); // "10"
  ```
- **Convert from String to Other Types:**
  ```java
  String strNumber = "10";
  int num = Integer.parseInt(strNumber); // 10
  ```

## M. Common Use Cases
- **Checking if a String is Empty:**
  ```java
  boolean isEmpty = str.isEmpty(); // false
  ```
- **Checking if a String Contains a Substring:**
  ```java
  boolean contains = str.contains("World"); // true
  ```

## N. Common Errors
- **Null Pointer Exception:**
  Always check if a string is null before performing operations on it to avoid exceptions.

 */