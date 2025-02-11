package com.performance.largefilereading;

import java.io.*;

class FileReadingComparison {
    public static void main(String[] args) {
        String[] filePaths = {
                "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week03\\Day06\\Day06\\src\\main\\java\\com\\performance\\largefilereading\\1MB.txt",
                "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week03\\Day06\\Day06\\src\\main\\java\\com\\performance\\largefilereading\\100MB.txt",
                "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week03\\Day06\\Day06\\src\\main\\java\\com\\performance\\largefilereading\\500MB.txt"
        };

        System.out.println("Comparing FileReader and InputStreamReader...");
        for (String filePath : filePaths) {
            System.out.println("Processing file: " + filePath);
            compareFileReading(filePath);
        }
    }

    private static void compareFileReading(String filePath) {
        try {
            // Using FileReader (Character Stream)
            long startTime = System.nanoTime();
            try (FileReader fileReader = new FileReader(filePath)) {
                while (fileReader.read() != -1) {
                    // Reading character by character
                }
            }
            long fileReaderTime = System.nanoTime() - startTime;
            System.out.println("FileReader Time for " + filePath + ": " + fileReaderTime + " ms");

            // Using InputStreamReader (Byte Stream)
            startTime = System.nanoTime();
            try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
                while (inputStreamReader.read() != -1) {
                    // Reading character by character
                }
            }
            long inputStreamReaderTime = System.nanoTime() - startTime;
            System.out.println("InputStreamReader Time for " + filePath + ": " + inputStreamReaderTime + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
