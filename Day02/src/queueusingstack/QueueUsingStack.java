package com.queueusingstack;
import java.util.Stack;

class QueueUsingStack {
    private Stack<Integer> stack1;  // Stack used for enqueue operation
    private Stack<Integer> stack2;  // Stack used for dequeue operation

    // Constructor to initialize stacks
    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: Adds an element to the queue
    public void enqueue(int element) {
        stack1.push(element);  // Push element to stack1
        System.out.println("Enqueued: " + element);
    }

    // Dequeue operation: Removes and returns the front element of the queue
    public int dequeue() {
        if (stack2.isEmpty()) {  // Moving elements only if stack2 is empty
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;  // Indicating queue is empty
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());  // Moving all elements to stack2
            }
        }
        int removedElement = stack2.pop();
        System.out.println("Dequeued: " + removedElement);
        return removedElement;
    }

    // Peek operation: Returns the front element without removing it
    public int peek() {
        if (stack2.isEmpty()) {  // If stack2 is empty, move elements from stack1
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty. Cannot peek.");
                return -1;  // Indicate queue is empty
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();  // Peek front element from stack2
    }

    //method to Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // method to Display the current state of the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue (Front to Rear): ");

        // Printing stack2 elements first (since they are dequeued first)
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }

        // Printing stack1 elements (they are still waiting to be moved)
        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        // Enqueue operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.displayQueue();

        // Dequeue operations
        queue.dequeue();
        queue.displayQueue();

        queue.dequeue();
        queue.displayQueue();

        // Peek operation
        System.out.println("Front element: " + queue.peek());

        // Enqueue more elements
        queue.enqueue(40);
        queue.enqueue(50);
        queue.displayQueue();

        // Dequeue remaining elements
        queue.dequeue();
        queue.dequeue();
        queue.displayQueue();

        queue.dequeue();
        queue.displayQueue();

        // Attempt to dequeue from an empty queue
        queue.dequeue();
    }
}
