package DSA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Map;

public class CollectionsExample {

    // HashMap Example
    public static void hashMapExample() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        System.out.println("Value for Apple: " + map.get("Apple")); // Output: 1
        System.out.println("Contains Banana: " + map.containsKey("Banana")); // Output: true

        map.remove("Orange"); // Removes Orange
        System.out.println("Size of map: " + map.size()); // Output: 2

        // Iterating over key-value pairs
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }

    // HashSet Example
    public static void hashSetExample() {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");

        System.out.println("Contains Apple: " + set.contains("Apple")); // Output: true

        set.remove("Banana"); // Removes Banana
        System.out.println("Size of set: " + set.size()); // Output: 2

        // Iterating over the set
        for (String fruit : set) {
            System.out.println(fruit); // Prints Apple and Orange (order is not guaranteed)
        }
    }

    // TreeMap Example
    public static void treeMapExample() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Apple", 1);
        treeMap.put("Banana", 2);
        treeMap.put("Orange", 3);

        System.out.println("Value for Apple: " + treeMap.get("Apple")); // Output: 1
        System.out.println("Contains Banana: " + treeMap.containsKey("Banana")); // Output: true

        treeMap.remove("Orange"); // Removes Orange
        System.out.println("Size of treeMap: " + treeMap.size()); // Output: 2

        // Iterating over key-value pairs
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }

    public static void main(String[] args) {
        System.out.println("HashMap Example:");
        hashMapExample();
        System.out.println("\nHashSet Example:");
        hashSetExample();
        System.out.println("\nTreeMap Example:");
        treeMapExample();
    }
}
