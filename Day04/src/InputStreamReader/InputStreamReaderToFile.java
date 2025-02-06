package com.inputstreamreader;

import java.io.*;

public class InputStreamReaderToFile {
    public static void main(String[] args) {
        // Specify the file to write the input
        String filePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 03\\Day4\\Day4\\src\\com\\inputstreamreader\\File3.txt"; // Adjust the path

        try (
                // Create an InputStreamReader to read from System.in (console)
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                // Wrap the InputStreamReader in a BufferedReader for efficient reading
                BufferedReader reader = new BufferedReader(inputStreamReader);
                // Create a FileWriter to write to the specified file
                FileWriter fileWriter = new FileWriter(filePath, true);  // 'true' for appending data to the file
                BufferedWriter writer = new BufferedWriter(fileWriter)
        ) {
            String userInput;
            System.out.println("Enter text (type 'exit' to stop):");

            // Read user input line by line and write to the file
            while (true) {
                userInput = reader.readLine();

                // If user types "exit", break out of the loop
                if ("exit".equalsIgnoreCase(userInput)) {
                    System.out.println("Exiting the program...");
                    break;
                }

                // Write the input to the file
                writer.write(userInput);
                writer.newLine();  // Write a newline after each input
            }

        } catch (IOException e) {
            // Handle possible IOExceptions
            e.printStackTrace();
        }
    }
}
