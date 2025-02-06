package FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        // Specify the file path to be read
        String filePath = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week03\\Day04\\src\\FileReader\\FileProblem1.txt";
        try {
            // Create a FileReader to read the file character by character
            FileReader file = new FileReader(filePath);

            // Wrap FileReader in BufferedReader for efficient reading line by line
            BufferedReader bufferedReader = new BufferedReader(file);

            // Declare a variable to hold a line of text
            String line;

            // Read each line from the file until the end (null) and print it
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader to free resources
            bufferedReader.close();
        }
        catch (IOException e) {
            // Handle any I/O exceptions that may occur
            e.printStackTrace();
        }
    }
}
