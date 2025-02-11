package com.performance.stringconcatenationperformance;

public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] dataset = {1000, 10000, 1000000};

        for (int n : dataset) {
            System.out.println("Testing for N = " + n);

            // Using String
            long startTime = System.nanoTime();
            testString(n);
            long endTime = System.nanoTime();
            System.out.println("String Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Using StringBuilder
            startTime = System.nanoTime();
            testStringBuilder(n);
            endTime = System.nanoTime();
            System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Using StringBuffer
            startTime = System.nanoTime();
            testStringBuffer(n);
            endTime = System.nanoTime();
            System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            System.out.println();
        }
    }

    private static void testString(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a"; // Creates a new object each time (O(N²) complexity)
        }
    }

    private static void testStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a"); // Efficient O(N) complexity
        }
    }

    private static void testStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a"); // Thread-safe but slightly slower
        }
    }
}
