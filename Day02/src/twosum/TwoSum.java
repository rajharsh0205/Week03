package com.twosum;
import java.util.HashMap;

public class TwoSum {

    // method to Find two indices whose values add up to the target sum
    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            }
            map.put(arr[i], i);
        }
        return null;  // Returning null if no pair is found
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 17;
        int[] result = twoSum(arr, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        }
    }
}
