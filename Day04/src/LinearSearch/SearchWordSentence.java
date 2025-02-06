package LinearSearch;

import java.util.Scanner;

public class SearchWordSentence {
    public static void main(String[] args) {
        // Array of sentences to search from
        String[] sentences = {
                "Java is a programming language",
                "It is also platform independent lang.",
                "It is secure and robust",
                "It follows object oriented concept"
        };

        // Prompting the user to enter a word to search
        System.out.println("Enter a Word to Search:");
        Scanner sc = new Scanner(System.in);
        String target = sc.next();

        // Iterating through each sentence in the array
        for (String str : sentences) {
            // Splitting the sentence into words and checking each word
            for (String s : str.split(" ")) {
                // Case-insensitive comparison with the target word
                if (s.equalsIgnoreCase(target)) {
                    System.out.println(str);
                    return;
                }
            }
        }

        // If no match is found, print "Not Found"
        System.out.println("Not Found");

        // Closing scanner to prevent resource leak
        sc.close();
    }
}
