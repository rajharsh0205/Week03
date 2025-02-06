package BinarySearch;

public class RotationPointFinder {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // If mid element is greater than the rightmost element, search in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else { // Otherwise, search in the left half (including mid)
                right = mid;
            }
        }
        return left; // The index of the smallest element
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9, 1,2, 3, 4, 5};
        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation Index: " + rotationIndex);
        System.out.println("Smallest Element: " + arr[rotationIndex]);
    }
}
