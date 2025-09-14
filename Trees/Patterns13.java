import java.util.*;

// Sliding Window and Two Pointer
class patterns13 {
    // Function to find the maximum sum of a subarray of size k
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        int maxSum = 0;
        int currentSum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;

        // Slide the window over the array
        for (int i = k; i < n; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // Test case for Sliding Window
    public static void testSlidingWindow() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max sum of subarray of size " + k + ": " + maxSumSubarray(arr, k)); // 9
    }

    // Greedy (Mostly Sorting)
    // Function to find the minimum number of platforms required for the train schedule
    public static int findPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platforms = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            result = Math.max(result, platforms);
        }
        return result;
    }

    // Test case for Greedy (Sorting)
    public static void testGreedy() {
        int[] arr = {10, 15, 20, 25};
        int[] dep = {12, 17, 27, 40};
        System.out.println("Minimum platforms required: " + findPlatform(arr, dep)); // 2
    }

    // Binary Search on Answer
    // Function to find the minimum element in rotated sorted array
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    // Test case for Binary Search on Answer
    public static void testBinarySearch() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum element in rotated sorted array: " + findMin(nums)); // 0
    }

    // K Smallest / K Largest → Heaps
    // Function to find the K largest elements in an array
    public static int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }

    // Test case for K Largest
    public static void testKLargest() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("K largest elements: " + Arrays.toString(kLargest(arr, k))); // [5, 6]
    }

    // Prefix/Suffix/Word Search → Tries
    // Function to add words to Trie
    static class Trie {
        Trie[] children = new Trie[26];
        boolean isEndOfWord = false;

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.isEndOfWord;
        }
    }

    // Test case for Trie
    public static void testTrie() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search for 'apple': " + trie.search("apple")); // true
        System.out.println("Search for 'app': " + trie.search("app")); // false
    }

    // Graph - DFS / BFS
    // Function to perform BFS on a graph
    public static void bfs(int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor = 0; neighbor < graph.length; neighbor++) {
                if (graph[node][neighbor] == 1 && !visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    // Test case for BFS
    public static void testBFS() {
        int[][] graph = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 0, 0}
        };
        System.out.print("BFS traversal starting from node 0: ");
        bfs(graph, 0); // 0 1 3 2
        System.out.println();
    }

    // Topological Sort
    // Function to perform Topological Sort using DFS
    public static List<Integer> topologicalSort(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topologicalSortDFS(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static void topologicalSortDFS(int[][] graph, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor = 0; neighbor < graph.length; neighbor++) {
            if (graph[node][neighbor] == 1 && !visited[neighbor]) {
                topologicalSortDFS(graph, neighbor, visited, stack);
            }
        }
        stack.push(node);
    }

    // Test case for Topological Sort
    public static void testTopologicalSort() {
        int[][] graph = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        System.out.println("Topological Sort: " + topologicalSort(graph)); // [0, 1, 2, 3]
    }

    // Bitwise XOR
    // Function to find the element that appears only once
    public static int findUnique(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // Test case for Bitwise XOR
    public static void testXOR() {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Element that appears only once: " + findUnique(nums)); // 4
    }

    // Tree - DFS/BFS
    // Function to perform DFS on a binary tree
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        dfs(root.left);
        dfs(root.right);
    }

    // Test case for Tree DFS
    public static void testTreeDFS() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("DFS traversal of tree: ");
        dfs(root); // 1 2 4 5 3
        System.out.println();
    }

    // Slow and Fast Pointers - LinkedList
    // Function to detect cycle in a linked list using Floyd’s Tortoise and Hare algorithm
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Test case for Slow and Fast Pointers
    public static void testCycleDetection() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;

        System.out.println("Does the linked list have a cycle? " + hasCycle(head)); // true
    }

    // Parenthesis Problems - Stack
    // Function to check if parentheses are balanced
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (c == ')' && open != '(' || c == '}' && open != '{' || c == ']' && open != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Test case for Parenthesis Problems
    public static void testParentheses() {
        String s = "()[]{}";
        System.out.println("Is the parentheses string valid? " + isValid(s)); // true
    }

    // DP - Knapsack Problem
    // Function for the 0/1 Knapsack problem
    public static int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    // Test case for DP - Knapsack Problem
    public static void testKnapsack() {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 5;
        System.out.println("Max value in Knapsack: " + knapsack(weights, values, W)); // 7
    }

    // Main method to test all topics
    public static void main(String[] args) {
        testSlidingWindow();
        testGreedy();
        testBinarySearch();
        testKLargest();
        testTrie();
        testBFS();
        testTopologicalSort();
        testXOR();
        testTreeDFS();
        testCycleDetection();
        testParentheses();
        testKnapsack();
    }
}

// ListNode class for LinkedList
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
