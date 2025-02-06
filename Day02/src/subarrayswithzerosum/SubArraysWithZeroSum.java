package com.subarrayswithzerosum;
import java.util.*;

class SubArraywithZeroSum {
    // Method to find and print all subarrays with zero sum
    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>(); // Stores cumulative sum and indices
        int sum = 0;

        // Initialize the map with sum 0 at index -1 (to handle cases where subarray starts from index 0)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Compute cumulative sum

            // If the sum is already in the map, it means we found subarrays with zero sum
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray found from index " + (start + 1) + " to " + i);
                }
            }

            // Add current sum to the map
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, -4, -2, 2, -2};

        System.out.println("Zero-sum subarrays:");
        findZeroSumSubarrays(arr);
    }
}
