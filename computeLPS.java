public class computeLPS {
    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int length = 0; // Length of previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Move length back
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        // Test case
        String testString = "importantSolution";
        int[] lpsArray = computeLPS(testString);

        // Print the LPS array
        System.out.print("Test case 1 LPS Output: ");
        for (int val : lpsArray) {
            System.out.print(val + " ");
        }
    }
}
