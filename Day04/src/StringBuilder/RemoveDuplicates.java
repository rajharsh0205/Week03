package StringBuilder;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {

    public static String removeDuplicates(String str) {
        // StringBuilder to store the result string without duplicates
        StringBuilder result = new StringBuilder();
        // HashSet to keep track of characters already encountered
        HashSet<Character> set = new HashSet<>();

        // Iterate over each character in the input string
        for(char ch : str.toCharArray()) {
            // If the character has not been encountered before, add it to the result
            if(!set.contains(ch)) {
                // Mark the character as seen
                set.add(ch);
                // Append the character to the result
                result.append(ch);
            }
        }
        // Convert StringBuilder to String and return
        return result.toString();
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = sc.nextLine();
        sc.close();

        String output = removeDuplicates(input);
        System.out.println("Original String: " + input);
        System.out.println("String without duplicates: " + output);
    }
}


