package com.stockspanproblem;
import java.util.Stack;

public class StockSpanProblem {

    // Calculate stock span for each day
    public static int[] stockSpan(int[] prices) {
        int[] span = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {10, 4, 5, 90, 120, 80};
        int[] result = stockSpan(prices);
        for (int span : result) {
            System.out.print(span + " ");
        }
    }
}
