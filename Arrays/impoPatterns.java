import java.util.*;

public class impoPatterns {

    // Sliding Window and Two Pointer
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;

        for (int i = k; i < n; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void testSlidingWindow() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max sum of subarray of size " + k + ": " + maxSumSubarray(arr, k)); // 9
    }

    // Greedy (Sorting)
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

    public static void testGreedy() {
        int[] arr = {10, 15, 20, 25};
        int[] dep = {12, 17, 27, 40};
        System.out.println("Minimum platforms required: " + findPlatform(arr, dep)); // 2
    }

    // Binary Search on Answer
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

    public static void testBinarySearch() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum element in rotated sorted array: " + findMin(nums)); // 0
    }

    // K Largest → Heaps
    public static int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.offer(i);
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

    public static void testKLargest() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("K largest elements: " + Arrays.toString(kLargest(arr, k))); // [5, 6]
    }

    // Prefix/Suffix/Word Search → Tries
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

    public static void testTrie() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search for 'apple': " + trie.search("apple")); // true
        System.out.println("Search for 'app': " + trie.search("app")); // false
    }

    // Graph - BFS
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

    private static void topologicalSortDFS(int[][] graph, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor = 0; neighbor < graph.length; neighbor++) {
            if (graph[node][neighbor] == 1 && !visited[neighbor]) {
                topologicalSortDFS(graph, neighbor, visited, stack);
            }
        }
        stack.push(node);
    }

    public static void testTopologicalSort() {
        int[][] graph = {
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
        };
        System.out.println("Topological Sort: " + topologicalSort(graph)); // [0, 1, 2, 3]
    }

    // Test all patterns
    public static void main(String[] args) {
        testSlidingWindow();
        testGreedy();
        testBinarySearch();
        testKLargest();
        testTrie();
        testBFS();
        testTopologicalSort();
    }
}
