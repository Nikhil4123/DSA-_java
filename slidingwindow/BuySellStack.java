package slidingwindow;

public class BuySellStack {
    public int maxProfit(int[] prices) {
        int l = 0; // Left pointer, representing the buy day
        int r = 1; // Right pointer, representing the sell day
        int maxp = 0; // Maximum profit

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int p = prices[r] - prices[l]; // Calculate the profit
                maxp = Math.max(p, maxp); // Update the maximum profit
            } else {
                l = r; // Move the left pointer to the current right pointer
            }
            r++; // Move the right pointer forward
        }

        return maxp;
    }

    public static void main(String[] args) {
        BuySellStack buySellStack = new BuySellStack();

        // Test Case 1: Normal scenario with increasing and decreasing prices
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1: " + buySellStack.maxProfit(prices1)); // Output: 5

        // Test Case 2: Prices in decreasing order
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test 2: " + buySellStack.maxProfit(prices2)); // Output: 0

        // Test Case 3: Prices with only one day
        int[] prices3 = {5};
        System.out.println("Test 3: " + buySellStack.maxProfit(prices3)); // Output: 0

        // Test Case 4: Prices with constant values
        int[] prices4 = {5, 5, 5, 5, 5};
        System.out.println("Test 4: " + buySellStack.maxProfit(prices4)); // Output: 0

        // Test Case 5: Prices with a single peak
        int[] prices5 = {1, 2, 3, 4, 5};
        System.out.println("Test 5: " + buySellStack.maxProfit(prices5)); // Output: 4

        // Test Case 6: Prices with sharp dips and peaks
        int[] prices6 = {3, 8, 1, 5, 10};
        System.out.println("Test 6: " + buySellStack.maxProfit(prices6)); // Output: 9

        // Test Case 7: Prices with alternate ups and downs
        int[] prices7 = {2, 4, 1, 5, 3, 6, 4};
        System.out.println("Test 7: " + buySellStack.maxProfit(prices7)); // Output: 5
    }
}
