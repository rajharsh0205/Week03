package com.performance.searchcomparison;

import java.util.*;

public class SearchComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};
        Random rand = new Random();

        System.out.println("Comparing Searching Performance in Array, HashSet, and TreeSet...\n");

        for (int size : datasetSizes) {
            System.out.println("Dataset Size: " + size);

            // Generate dataset
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int num = rand.nextInt(size * 10); // Ensure unique numbers
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            int target = array[size / 2]; // Pick a middle value to search

            // Measure Array Search Time (O(N))
            long startArray = System.nanoTime();
            boolean foundArray = linearSearch(array, target);
            long endArray = System.nanoTime();
            System.out.println("Array Search Found: " + foundArray + ", Time: " + (endArray - startArray) / 1e6 + " ms");

            // Measure HashSet Search Time (O(1))
            long startHashSet = System.nanoTime();
            boolean foundHashSet = hashSet.contains(target);
            long endHashSet = System.nanoTime();
            System.out.println("HashSet Search Found: " + foundHashSet + ", Time: " + (endHashSet - startHashSet) / 1e6 + " ms");

            // Measure TreeSet Search Time (O(log N))
            long startTreeSet = System.nanoTime();
            boolean foundTreeSet = treeSet.contains(target);
            long endTreeSet = System.nanoTime();
            System.out.println("TreeSet Search Found: " + foundTreeSet + ", Time: " + (endTreeSet - startTreeSet) / 1e6 + " ms");

            System.out.println("--------------------------------------");
        }
    }

    // Linear search for array (O(N))
    public static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) return true;
        }
        return false;
    }
}
