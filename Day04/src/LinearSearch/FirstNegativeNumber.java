package LinearSearch;

import java.util.Scanner;

public class FirstNegativeNumber {
    public static int linearSearch(int[] arr) {
        //Using for loop for iterating in an array
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < 0) {
                // It returns the index of a negative number
                return i;
            }
        }
        //It gives -1 if negative number not found
        return -1;
    }

    public static void main(String[] args) {
        //Taking user input using scanner class
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an Array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        //Calling the linearSearch method
        int output = linearSearch(arr);

        // Print the result index of the first negative number, or -1 if none found
        if (output == -1) {
            System.out.println("No negative number found in the array ");
        } else {
            System.out.println("First negative number found at index: " + output);
        }

        // Close the scanner to prevent resource leak
        sc.close();

    }
}
