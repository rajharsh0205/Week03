package com.customhashmap;
import java.util.LinkedList;

class CustomHashMap {
    // Node class representing key-value pairs
    private static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] table;  // Array of LinkedLists for separate chaining
    private static final int SIZE = 10;  // Fixed size of HashMap

    // Constructor to initialize the HashMap
    public CustomHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to map key to index
    private int getIndex(int key) {
        return key % SIZE;
    }

    // Insert a key-value pair
    public void put(int key, int value) {
        int index = getIndex(key);
        for (Node node : table[index]) {
            if (node.key == key) {  // Update value if key already exists
                node.value = value;
                return;
            }
        }
        table[index].add(new Node(key, value));  // Add new key-value pair
    }

    // Retrieve value by key
    public int get(int key) {
        int index = getIndex(key);
        for (Node node : table[index]) {
            if (node.key == key) {
                return node.value;  // Return value if key is found
            }
        }
        return -1;  // Return -1 if key not found
    }

    // Remove a key-value pair
    public void remove(int key) {
        int index = getIndex(key);
        table[index].removeIf(node -> node.key == key);  // Remove if key matches
    }

    // Display all key-value pairs in the HashMap
    public void display() {
        System.out.println("HashMap Contents:");
        for (int i = 0; i < SIZE; i++) {
            if (!table[i].isEmpty()) {
                System.out.print("Index " + i + ": ");
                for (Node node : table[i]) {
                    System.out.print("(" + node.key + " -> " + node.value + ") ");
                }
                System.out.println();
            }
        }
    }

    // Main method demonstrating all functionalities
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        // Insert key-value pairs
        map.put(1, 10);
        map.put(2, 20);
        map.put(12, 50);  // Collision case (1 % 10 == 12 % 10)
        map.put(3, 30);
        map.put(4, 40);
        map.put(14, 60);  // Collision case

        // Display HashMap after insertions
        map.display();

        // Retrieve values
        System.out.println("Value for key 1: " + map.get(1));
        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("Value for key 12: " + map.get(12));
        System.out.println("Value for key 99 (not present): " + map.get(99));

        // Remove a key and check
        map.remove(1);
        System.out.println("After removing key 1:");
        map.display();
        System.out.println("Value for key 1: " + map.get(1));

        // Remove another key and check
        map.remove(14);
        System.out.println("After removing key 14:");
        map.display();
    }
}
