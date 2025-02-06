package StringBuilder;
import java.util.Scanner;

public class ReverseString {
    public static String reverseString(String str) {
        // Create a new StringBuilder object and append the input string
        StringBuilder result = new StringBuilder(str);
        // Use the reverse() method to reverse the string and uses the toString() method to converts the StringBuilder back into a String so it can be returned as a regular Java String
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = sc.nextLine();
        sc.close();

        String output = reverseString(input);
        System.out.println("Original String: " + input);
        System.out.println("Reverse String: " + output);
    }
}
