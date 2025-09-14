package Sorting;

import java.util.Arrays;

public class InsertionSort {
    // Insertion Sort - Sorts the array in-place
    public void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Main method to test Insertion Sort
    public static void main(String[] args) {
        InsertionSort sorter = new InsertionSort();

        int[] arr1 = {64, 25, 12, 22, 11};
        int[] arr2 = {5, 3, 8, 4, 2};
        int[] arr3 = {10, 9, 8, 7, 6};

        sorter.insertionSort(arr1);
        sorter.insertionSort(arr2);
        sorter.insertionSort(arr3);

        System.out.println("Sorted Array 1: " + Arrays.toString(arr1));
        System.out.println("Sorted Array 2: " + Arrays.toString(arr2));
        System.out.println("Sorted Array 3: " + Arrays.toString(arr3));
    }
}
