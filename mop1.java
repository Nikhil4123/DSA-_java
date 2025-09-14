

import java.util.*;

public class mop1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Input the number of pairs
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        // Input the pairs
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        // HashSet to track unique pairs
        HashSet<String> st = new HashSet<>();
        
        // Process each pair and output the size of the HashSet
        for (int i = 0; i < t; i++) {
            String ne = pair_left[i] + " " + pair_right[i];
            st.add(ne);
            System.out.println(st.size()); // Print the current count of unique pairs
        }

        s.close();
    }
}
