package DSA;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ListExamples {

    public static void main(String[] args) {
        // Creating a List
        List<String> list = new ArrayList<>();

        // Adding Elements
        list.add("Apple");
        list.add("Banana");
        list.add(0, "Cherry");

        // Accessing Elements
        System.out.println("First Element: " + list.get(0));

        // Modifying Elements
        list.set(1, "Orange");

        // Removing Elements
        list.remove("Cherry");
        list.remove(0);

        // Checking size and other properties
        System.out.println("List Size: " + list.size());
        System.out.println("Is List Empty? " + list.isEmpty());
        System.out.println("Contains 'Banana'? " + list.contains("Banana"));

        // Iterating Over List
        System.out.println("Iterating with for loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Iterating with enhanced for loop:");
        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("Iterating with Lambda Expression:");
        list.forEach(item -> System.out.println(item));

        // Sorting List
        list.add("Apple");
        list.add("Cherry");
        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        // Filtering List (Java 8+)
        List<String> filteredList = list.stream()
                                        .filter(item -> item.startsWith("A"))
                                        .collect(Collectors.toList());
        System.out.println("Filtered List (Starts with 'A'): " + filteredList);

        // Mapping List (Java 8+)
        List<Integer> lengths = list.stream()
                                    .map(String::length)
                                    .collect(Collectors.toList());
        System.out.println("Lengths of each item: " + lengths);

        // Reducing List (Java 8+)
        String concatenated = list.stream()
                                  .reduce("", (a, b) -> a + b);
        System.out.println("Concatenated String: " + concatenated);

        // Parallel Stream (Java 8+)
        System.out.println("Parallel Stream:");
        list.parallelStream().forEach(item -> System.out.println(item));

        // Converting List to Array
        String[] array = list.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(array));

        // Converting Array to List
        List<String> newList = Arrays.asList(array);
        System.out.println("New List from Array: " + newList);
    }
}
