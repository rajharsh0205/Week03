package ChallengeProblem;

import java.util.Arrays;

public class LinearAndBinarySearch {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};  // Unsorted array
        int target = 3; // Target for binary search

        // Find first missing positive integer (Linear Search)
        int missingNumber = findFirstMissingPositive(nums);
        System.out.println("First Missing Positive: " + missingNumber);

        // Sort array for Binary Search
        Arrays.sort(nums);
        int targetIndex = binarySearch(nums, target);
        System.out.println("Index of " + target + ": " + targetIndex);
    }

    // Function to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number at its correct index if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // Swap helper function
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Binary Search function to find target index
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Found target
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right
            } else {
                right = mid - 1; // Search left
            }
        }
        return -1; // Target not found
    }
}
