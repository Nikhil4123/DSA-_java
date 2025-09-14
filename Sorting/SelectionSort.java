package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {64, 25, 12, 22, 11};
        int[] arr2 = {5, 3, 8, 4, 2};
        int[] arr3 = {10, 9, 8, 7, 6};

        selectionSort(arr1);
        selectionSort(arr2);
        selectionSort(arr3);

        System.out.println("Sorted Array 1: " + Arrays.toString(arr1));
        System.out.println("Sorted Array 2: " + Arrays.toString(arr2));
        System.out.println("Sorted Array 3: " + Arrays.toString(arr3));
    }
}
