class maxScore {
    public int maxScore(int[] arr) {
        int n = arr.length;
        int maxScore = Integer.MIN_VALUE; // Initialize the maximum score

        // Iterate over all possible subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Ensure j > i
                int min1 = Integer.MAX_VALUE; // Smallest element
                int min2 = Integer.MAX_VALUE; // Second smallest element

                // Find smallest and second smallest in arr[i...j]
                for (int k = i; k <= j; k++) {
                    if (arr[k] < min1) {
                        min2 = min1; // Update second smallest
                        min1 = arr[k]; // Update smallest
                    } else if (arr[k] < min2) {
                        min2 = arr[k];
                    }
                }

                // Calculate score and update maxScore
                if (min2 != Integer.MAX_VALUE) { // Ensure subarray has at least two elements
                    maxScore = Math.max(maxScore, min1 + min2);
                }
            }
        }

        return maxScore; // Return the maximum score
    }

    public static void main(String[] args) {
        maxScore solution = new maxScore();
        int[] arr = {4, 3, 1, 5, 6};
        System.out.println("Maximum Score: " + solution.maxScore(arr));
    }
}
