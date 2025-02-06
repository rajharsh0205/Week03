package com.longestconsecutivesequence;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Find length of longest consecutive sequence
    public static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) {  // Start of a sequence
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of longest consecutive sequence is : " + longestConsecutive(arr));
    }
}
