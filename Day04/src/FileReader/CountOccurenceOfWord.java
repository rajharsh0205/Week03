package FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurenceOfWord {
    public static void main(String[] args) {
        // Define the file path to the text file
        String filePath = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week03\\Day04\\src\\FileReader\\FileProblem2.txt";

        try {
            // Create a FileReader object to read from the file specified by filePath
            FileReader file = new FileReader(filePath);

            // Wrap the FileReader in a BufferedReader to read lines efficiently
            BufferedReader bufferReader = new BufferedReader(file);

            // Define the target word we are counting in the file
            String target = "my";
            // Variable to hold each line read from the file
            String line;
            // Variable to count occurrences of the target word
            int count = 0;

            // Loop through the file, reading line by line
            while((line = bufferReader.readLine()) != null) {
                // Split the line into words by spaces and loop through each word
                for(String str : line.split(" ")) {
                    // Check if the current word matches the target (case-insensitive)
                    if(str.equalsIgnoreCase(target)) {
                        // Increment the count if the word matches
                        count++;
                    }
                }
            }
            // Print the final count of occurrences
            System.out.println(count);

            // Close the BufferedReader to release resources
            bufferReader.close();
        }
        catch(IOException e) {
            // Handle any IOException (such as file not found or read error) and print the stack trace
            e.printStackTrace();
        }
    }
}
