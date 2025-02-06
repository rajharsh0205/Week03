package com.inputstreamreader;

import java.io.*;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        // Specify the file path of the binary file
        String filePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 03\\Day4\\Day4\\src\\com\\inputstreamreader\\File3.txt";  // Adjust the path

        try (
                // Create a FileInputStream to read the binary data from the file
                FileInputStream fileInputStream = new FileInputStream(filePath);
                // Wrap FileInputStream with InputStreamReader to convert byte stream to character stream
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");  // Specify charset (e.g., UTF-8)
                // Wrap InputStreamReader with BufferedReader for efficient reading
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;
            // Read the file line by line and print the characters to the console
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Handle possible IOExceptions, such as file not found or encoding issues
            e.printStackTrace();
        }
    }
}

