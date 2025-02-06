package ChallengeProblem;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class PerformanceComparision {
    public static void main(String[] args) {
        // Compare StringBuilder and StringBuffer
        compareStringBuilders();

        // Compare FileReader and InputStreamReader with given file path
        String filePath = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week03\\Day04\\src\\ChallengeProblem\\File2.txt";
        compareReaders(filePath);
    }

    // Function to compare StringBuilder vs StringBuffer
    private static void compareStringBuilders() {
        int iterations = 1_000_000;
        String text = "hello";

        // StringBuilder Performance
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " ms");

        // StringBuffer Performance
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " ms");
    }

    // Function to compare FileReader vs InputStreamReader
    private static void compareReaders(String filePath) {
        System.out.println("\nReading File: " + filePath);

        // Verify if file exists before proceeding
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Error: File not found at " + filePath);
            return;
        }

        // Using FileReader
        long startTime = System.currentTimeMillis();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        long endTime = System.currentTimeMillis();
        System.out.println("FileReader - Word Count: " + wordCountFileReader + ", Time: " + (endTime - startTime) + " ms");

        // Using InputStreamReader
        startTime = System.currentTimeMillis();
        int wordCountStreamReader = countWordsUsingStreamReader(filePath);
        endTime = System.currentTimeMillis();
        System.out.println("InputStreamReader - Word Count: " + wordCountStreamReader + ", Time: " + (endTime - startTime) + " ms");
    }

    // Read file using FileReader
    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    // Read file using InputStreamReader
    private static int countWordsUsingStreamReader(String filePath) {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }
}
