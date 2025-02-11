package com.performance.searchtarget;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

public class SearchTargetTest {

    private int[] sortedArray;
    private int[] unsortedArray;
    private int target;
    private Random random;

    @BeforeEach
    void setUp() {
        random = new Random();

        // Initialize sorted array
        sortedArray = new int[]{1, 3, 5, 7, 9, 11, 15, 18, 21, 25};

        // Initialize unsorted array
        unsortedArray = new int[]{7, 1, 9, 3, 5, 25, 11, 21, 15, 18};

        // Choose a random target from the sorted array for testing
        target = sortedArray[random.nextInt(sortedArray.length)];
    }

    @Test
    void testLinearSearch_Found() {
        int index = SearchTarget.linearSearch(unsortedArray, 9);
        assertTrue(index >= 0, "Linear search should find the target in the array.");
    }

    @Test
    void testLinearSearch_NotFound() {
        int index = SearchTarget.linearSearch(unsortedArray, 100);
        assertEquals(-1, index, "Linear search should return -1 when the target is not found.");
    }

    @Test
    void testBinarySearch_Found() {
        int index = SearchTarget.binarySearch(sortedArray, 9);
        assertTrue(index >= 0, "Binary search should find the target in the sorted array.");
    }

    @Test
    void testBinarySearch_NotFound() {
        int index = SearchTarget.binarySearch(sortedArray, 100);
        assertEquals(-1, index, "Binary search should return -1 when the target is not found.");
    }

    @Test
    void testBinarySearch_FirstElement() {
        int index = SearchTarget.binarySearch(sortedArray, 1);
        assertEquals(0, index, "Binary search should correctly find the first element.");
    }

    @Test
    void testBinarySearch_LastElement() {
        int index = SearchTarget.binarySearch(sortedArray, 25);
        assertEquals(sortedArray.length - 1, index, "Binary search should correctly find the last element.");
    }

    @Test
    void testBinarySearch_MiddleElement() {
        int index = SearchTarget.binarySearch(sortedArray, 9);
        assertEquals(4, index, "Binary search should correctly find the middle element.");
    }

    @Test
    void testBinarySearch_EmptyArray() {
        int[] emptyArray = new int[]{};
        int index = SearchTarget.binarySearch(emptyArray, 10);
        assertEquals(-1, index, "Binary search should return -1 for an empty array.");
    }

    @Test
    void testLinearSearch_EmptyArray() {
        int[] emptyArray = new int[]{};
        int index = SearchTarget.linearSearch(emptyArray, 10);
        assertEquals(-1, index, "Linear search should return -1 for an empty array.");
    }

    @Test
    void testBinarySearch_SingleElement_Found() {
        int[] singleElementArray = new int[]{5};
        int index = SearchTarget.binarySearch(singleElementArray, 5);
        assertEquals(0, index, "Binary search should find the element in a single-element array.");
    }

    @Test
    void testLinearSearch_SingleElement_Found() {
        int[] singleElementArray = new int[]{5};
        int index = SearchTarget.linearSearch(singleElementArray, 5);
        assertEquals(0, index, "Linear search should find the element in a single-element array.");
    }

    @Test
    void testBinarySearch_SingleElement_NotFound() {
        int[] singleElementArray = new int[]{5};
        int index = SearchTarget.binarySearch(singleElementArray, 10);
        assertEquals(-1, index, "Binary search should return -1 if the element is not found in a single-element array.");
    }

    @Test
    void testLinearSearch_SingleElement_NotFound() {
        int[] singleElementArray = new int[]{5};
        int index = SearchTarget.linearSearch(singleElementArray, 10);
        assertEquals(-1, index, "Linear search should return -1 if the element is not found in a single-element array.");
    }
}