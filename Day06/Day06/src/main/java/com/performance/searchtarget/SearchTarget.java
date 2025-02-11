package com.performance.searchtarget;

import java.util.Arrays;
import java.util.Random;


public class SearchTarget {

    //Linear Search
    public static int linearSearch(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        //If not found
        return -1;
    }

    //Binary Search (sorted array provided)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;

        while(left<=right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        //If not found
        return -1;
    }


    //Method to measure execution time for both searches
    public static void analyzePerformance(int size) {
        Random random = new Random();
        int[] arr = new int[size];

        //Generating random values
        for(int i=0; i<arr.length; ++i) {
            arr[i] = random.nextInt(size*10);
        }
        //Choosing a random target
        int target = arr[random.nextInt(size)];

        long startTime = System.nanoTime();
        linearSearch(arr, target);
        long linearTime = System.nanoTime() - startTime;

        //Sorting array before Binary_Search
        Arrays.sort(arr);

        startTime = System.nanoTime();
        binarySearch(arr, target);
        long binaryTime = System.nanoTime() - startTime;

        System.out.println("Dataset : " + size + " | Linear_Search : " + linearTime + " | Binary_Search : " + binaryTime);
    }


    public static void main(String[] args) {
        //Dataset sizes
        int[] sizes = {1000, 10000, 1000000};

        System.out.println("Comparision of performance of Linear_Search (O(N)) and Binary_Search (O(N Log N))");

        for(int n : sizes) {
            analyzePerformance(n);
        }
    }
}
