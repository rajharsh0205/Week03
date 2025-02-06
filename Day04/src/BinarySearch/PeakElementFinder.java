package BinarySearch;

public class PeakElementFinder {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peak = findPeakElement(arr);
        System.out.println("A peak element is: " + peak);
    }

    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak
            if (arr[mid] > arr[mid + 1]) {
                right = mid; // Move left (potential peak found)
            } else {
                left = mid + 1; // Move right
            }
        }

        // 'left' will be at a peak element
        return arr[left];
    }
}
