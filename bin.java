public class Bin {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 5, 2};

        for (int i = 2	; i < arr.length; i++) { 
            if ((i - 2) % 3 == 0) {
                int t = (arr[i] + arr[i - 1] + arr[i - 2]) / 3;
                arr[i] = t;
                arr[i - 1] = t;
                arr[i - 2] = t; 
            }
        }

        for (int num : arr) {
            System.out.println(num);
        }
    }
}
