public class ArrayOperations {

    public static void main(String[] args) {
        // Example 1: StringBuilder with spaces
        String s = "This is a test";
        int[] spaces = {4, 7};  // Indices where spaces should be added
        System.out.println("String with spaces: " + addSpaces(s, spaces));

        // Example 2: Next Greater Element for two arrays
        int[] nums1 = {4,2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.print("Next greater elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 3: QuickSort to sort an array
        int[] arr = {5, 2, 8, 1, 3};
        System.out.println("Array before sorting: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Array after sorting: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Example 1: Method to add spaces in string at given indices
    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Example 2: Next Greater Element method
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int a = nums1[i];
            arr[i] = -1;  // Default value if no greater element is found
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == a && j < nums2.length - 1) {
                    if (nums2[j + 1] > a) {
                        arr[i] = nums2[j + 1];
                        break;
                    }
                }
            }
        }
        return arr;
    }

    // Example 3: QuickSort algorithm
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function for QuickSort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap the pivot element with the element at i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
