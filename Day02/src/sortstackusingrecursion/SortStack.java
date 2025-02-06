package com.sortstackusingrecursion;
import java.util.Stack;

public class SortStack {

    // Insert element in sorted order
    private static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        sortedInsert(stack, element);
        stack.push(temp);
    }

    // Sort stack recursively
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            sortedInsert(stack, temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(20);
        stack.push(50);
        stack.push(40);
        stack.push(10);

        sortStack(stack);
        System.out.println(stack);  // Output: [10, 20, 30, 40, 50]
    }
}
