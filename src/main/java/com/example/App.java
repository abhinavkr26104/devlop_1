package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Simple list of fruits
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits);
        
        // Define source and destination files
        File sourceFile = new File("source.txt");
        File destFile = new File("destination.txt");

        try {
            // Copy file using basic Java I/O
            copyFile(sourceFile, destFile);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("Error occurred while copying file: " + e.getMessage());
        }
    }

    // Basic file copy method using FileInputStream and FileOutputStream
    public static void copyFile(File source, File destination) throws IOException {
        try (FileInputStream inStream = new FileInputStream(source);
             FileOutputStream outStream = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
        }
    }
}

