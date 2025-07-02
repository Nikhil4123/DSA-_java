import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArrayOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> occurrences = new HashMap<>();

        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            arrayList.add(element);
            
            // Update occurrences in the HashMap
            occurrences.put(element, occurrences.getOrDefault(element, 0) + 1);
        }

        // Print the ArrayList
        System.out.println("ArrayList: " + arrayList);

        // Print the occurrences
        System.out.println("Occurrences:");
        for (int key : occurrences.keySet()) {
            System.out.println(key + " -> " + occurrences.get(key));
        }
        
        scanner.close();
    }
}
