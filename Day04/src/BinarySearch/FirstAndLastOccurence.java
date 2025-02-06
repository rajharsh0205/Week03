package BinarySearch;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2,3, 4, 5};
        int target = 2;

        int[] result = findFirstAndLastOccurrence(arr, target);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }

    public static int[] findFirstAndLastOccurrence(int[] arr, int target) {
        int first = findOccurrence(arr, target, true);
        int last = findOccurrence(arr, target, false);
        return new int[]{first, last};
    }

    private static int findOccurrence(int[] arr, int target, boolean findFirst) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid; // Store the index
                if (findFirst) {
                    right = mid - 1; // Search on the left for first occurrence
                } else {
                    left = mid + 1; // Search on the right for last occurrence
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}