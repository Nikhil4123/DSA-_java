import java.util.Arrays;

public class tp {
    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            System.out.println("=== TASK SCHEDULING ALGORITHM ===");
            System.out.println("Tasks: " + Arrays.toString(tasks));
            System.out.println("Cooldown period (n): " + n);
            System.out.println();
            
            // Step 1: Count frequency of each task
            System.out.println("STEP 1: Count task frequencies");
            int[] count = new int[26];
            for (char c : tasks) {
                count[c - 'A']++;
                System.out.println("  Processing task '" + c + "' -> count[" + (c - 'A') + "] = " + count[c - 'A']);
            }
            
            System.out.println("\nTask frequency summary:");
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    System.out.println("  " + (char)('A' + i) + ": " + count[i] + " times");
                }
            }
            
            // Step 2: Sort to find maximum frequency
            System.out.println("\nSTEP 2: Sort frequencies to find maximum");
            System.out.println("Before sorting: " + Arrays.toString(count));
            Arrays.sort(count);
            System.out.println("After sorting: " + Arrays.toString(count));
            
            int maxFreq = count[25];
            System.out.println("Maximum frequency: " + maxFreq + " (at index 25)");
            
            // Step 3: Count how many tasks have maximum frequency
            System.out.println("\nSTEP 3: Count tasks with maximum frequency");
            int maxCount = 0;
            for (int i = 25; i >= 0 && count[i] == maxFreq; i--) {
                maxCount++;
                System.out.println("  count[" + i + "] = " + count[i] + " equals maxFreq, maxCount = " + maxCount);
            }
            System.out.println("Total tasks with max frequency: " + maxCount);
            
            // Step 4: Calculate scheduling parameters
            System.out.println("\nSTEP 4: Calculate scheduling parameters");
            int partCount = maxFreq - 1;
            System.out.println("Part count = maxFreq - 1 = " + maxFreq + " - 1 = " + partCount);
            System.out.println("  (This represents gaps between occurrences of max frequency tasks)");
            
            int partLength = n - (maxCount - 1);
            System.out.println("Part length = n - (maxCount - 1) = " + n + " - (" + maxCount + " - 1) = " + n + " - " + (maxCount - 1) + " = " + partLength);
            System.out.println("  (This is the available space in each gap after placing max frequency tasks)");
            
            int emptySlots = partCount * partLength;
            System.out.println("Empty slots = partCount × partLength = " + partCount + " × " + partLength + " = " + emptySlots);
            System.out.println("  (Total empty spaces that need to be filled)");
            
            int availableTasks = tasks.length - maxFreq * maxCount;
            System.out.println("Available tasks = total tasks - (maxFreq × maxCount)");
            System.out.println("                = " + tasks.length + " - (" + maxFreq + " × " + maxCount + ")");
            System.out.println("                = " + tasks.length + " - " + (maxFreq * maxCount) + " = " + availableTasks);
            System.out.println("  (Tasks that can be used to fill empty slots)");
            
            int idles = Math.max(0, emptySlots - availableTasks);
            System.out.println("Idle intervals = max(0, emptySlots - availableTasks)");
            System.out.println("               = max(0, " + emptySlots + " - " + availableTasks + ")");
            System.out.println("               = max(0, " + (emptySlots - availableTasks) + ") = " + idles);
            System.out.println("  (Idle time needed when we don't have enough tasks to fill gaps)");
            
            int result = tasks.length + idles;
            System.out.println("\nSTEP 5: Calculate final result");
            System.out.println("Total intervals = tasks.length + idles = " + tasks.length + " + " + idles + " = " + result);
            
            // Step 6: Show the scheduling visualization
            System.out.println("\nSTEP 6: Scheduling visualization");
            if (idles > 0) {
                System.out.println("With cooldown period " + n + ", the optimal schedule would look like:");
                System.out.println("Example: A -> B -> idle -> A -> B -> idle -> A -> B");
                System.out.println("Total time units needed: " + result);
            } else {
                System.out.println("No idle time needed! Tasks can be scheduled continuously.");
                System.out.println("Total time units needed: " + result);
            }
            
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test Case 1
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TEST CASE 1");
        System.out.println("=".repeat(50));
        char[] tasks1 = {'A','A','A','B','B','B'};
        int n1 = 2;
        int result1 = sol.leastInterval(tasks1, n1);
        System.out.println("\n>>> FINAL ANSWER: " + result1 + " intervals needed <<<");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TEST CASE 2");
        System.out.println("=".repeat(50));
        char[] tasks2 = {'A','A','A','B','B','B'};
        int n2 = 0;
        int result2 = sol.leastInterval(tasks2, n2);
        System.out.println("\n>>> FINAL ANSWER: " + result2 + " intervals needed <<<");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TEST CASE 3");
        System.out.println("=".repeat(50));
        char[] tasks3 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n3 = 2;
        int result3 = sol.leastInterval(tasks3, n3);
        System.out.println("\n>>> FINAL ANSWER: " + result3 + " intervals needed <<<");
    }
}
