import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();

        ArrayList<String> result = generateBinaryStrings(k);
        System.out.println(result.size());
        System.out.println(result);
    }

    public static ArrayList<String> generateBinaryStrings(int k) {
        ArrayList<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add("0");
        queue.add("1");

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.length() == k) {
                result.add(current);
            } else {
                queue.add(current + "0"); // Always add "0"
                if (current.charAt(current.length() - 1) != '1') {
                    queue.add(current + "1"); // Add "1" only if last character is not '1'
                }
            }
        }
        return result;
    }
}
