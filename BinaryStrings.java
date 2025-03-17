import java.util.Scanner;

class BinaryStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();

        char[] str = new char[k];

        // Generate all binary strings starting with '0'
        str[0] = '0';
        generateAllStrings(k, str, 1);

        // Generate all binary strings starting with '1'
        str[0] = '1';
        generateAllStrings(k, str, 1);
    }

    public static void generateAllStrings(int k, char[] str, int n) {
        if (n == k) {  // Base Case: If string is of length K, print it
            System.out.println(new String(str));
            return;
        }

        // If the previous character is '1', we can only place '0'
        if (str[n - 1] == '1') {
            str[n] = '0';
            generateAllStrings(k, str, n + 1);
        } else { // If the previous character is '0', we can place both '0' and '1'
            str[n] = '0';
            generateAllStrings(k, str, n + 1);

            str[n] = '1';
            generateAllStrings(k, str, n + 1);
        }
    }
}
