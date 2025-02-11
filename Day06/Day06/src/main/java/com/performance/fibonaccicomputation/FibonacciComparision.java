package com.performance.fibonaccicomputation;

import java.util.Scanner;

public class FibonacciComparision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] testCases = {10, 30, 50}; // Test values

        System.out.println("Comparing Recursive vs Iterative Fibonacci Computation...\n");

        for (int n : testCases) {
            System.out.println("Fibonacci Number: N = " + n);

            // Measure Recursive Time
            long startRecursive = System.currentTimeMillis();
            int fibRec = fibonacciRecursive(n);
            long endRecursive = System.currentTimeMillis();
            System.out.println("Recursive Result: " + fibRec);
            System.out.println("Recursive Time: " + (endRecursive - startRecursive) + " ms");

            // Measure Iterative Time
            long startIterative = System.currentTimeMillis();
            int fibIter = fibonacciIterative(n);
            long endIterative = System.currentTimeMillis();
            System.out.println("Iterative Result: " + fibIter);
            System.out.println("Iterative Time: " + (endIterative - startIterative) + " ms");

            System.out.println("--------------------------------------");
        }
        scanner.close();
    }

    // Recursive Fibonacci (O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
