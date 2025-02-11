package com.performance.sortinglargedata;

import java.util.Arrays;
import java.util.Random;

public class SortingLargeData {
    public static void main(String[] args) {
        Random rm = new Random();
        int[] datasets = {1000, 10000, 1000000};

        for (int n : datasets) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = rm.nextInt(n * 10);
            }

            int[] dataCopy1 = Arrays.copyOf(data, data.length);
            int[] dataCopy2 = Arrays.copyOf(data, data.length);
            int[] dataCopy3 = Arrays.copyOf(data, data.length);

            // Bubble Sort
            long startTime = System.nanoTime();
            bubbleSort(dataCopy1);
            long endTime = System.nanoTime();
            System.out.println("Dataset Size: " + n);
            System.out.println("Bubble Sort Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Merge Sort
            startTime = System.nanoTime();
            mergeSort(dataCopy2);
            endTime = System.nanoTime();
            System.out.println("Merge Sort Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Quick Sort
            startTime = System.nanoTime();
            quickSort(dataCopy3, 0, dataCopy3.length - 1);
            endTime = System.nanoTime();
            System.out.println("Quick Sort Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
            System.out.println();
        }

    }
    private static void bubbleSort ( int[] array){
        int length = array.length;
        boolean swapped = false;
        for (int i = 0; i < length; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }
    private static void mergeSort ( int[] array){
        int length = array.length;
        int mid = length / 2;
        if (length < 2) {
            return;
        }
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < length; i++) {
            rightArray[i - mid] = array[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);
    }
    private static void merge ( int[] array, int[] leftArray, int[] rightArray){
        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray.length;

        int i = 0, j = 0, k = 0;
        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftArrayLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArrayLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    private static void quickSort ( int[] array, int lowIndex, int highIndex){

        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }

        swap(array, leftPointer, highIndex);
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }
    private static void swap ( int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
