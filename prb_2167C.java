import java.util.*;

public class prb_2167C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // PriorityQueue that stores sorted arrays in a sorted way
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> {
            // compare first element
            if (!a.get(0).equals(b.get(0)))
                return a.get(0) - b.get(0);

            // if first same, compare size
            if (a.size() != b.size())
                return a.size() - b.size();

            // if size same, compare full list
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i)))
                    return a.get(i) - b.get(i);
            }

            return 0; // equal
        });

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            Collections.sort(arr); // sort the small array

            pq.add(arr); // add to PQ
        }

        // print in sorted order
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
