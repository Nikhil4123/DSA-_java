class maxScore2 {
    public int maxScore2(int[] arr) {
        int n = arr.length;
        int maxScore = Integer.MIN_VALUE;

        // Iterate through all starting indices
        for (int i = 0; i < n - 1; i++) {
            int min1 = arr[i]; // Smallest element
            int min2 = Integer.MAX_VALUE; // Second smallest element

            // Find min1 and min2 in subarray arr[i...j]
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < min1) {
                    min2 = min1; // Update second smallest
                    min1 = arr[j]; // Update smallest
                } else if (arr[j] < min2) {
                    min2 = arr[j];
                }

                // Update maxScore with min1 + min2
                if (min2 != Integer.MAX_VALUE) {
                    maxScore = Math.max(maxScore, min1 + min2);
                }
            }
        }

        return maxScore; // Return the maximum score
    }

    public static void main(String[] args) {
        maxScore2 solution = new maxScore2();
        int[] arr = {4, 3, 1, 5, 6};
        System.out.println("Maximum Score: " + solution.maxScore2(arr));
    }
}
