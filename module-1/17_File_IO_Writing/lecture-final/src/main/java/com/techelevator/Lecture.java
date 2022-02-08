package com.techelevator;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lecture {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        /*
         * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
         * modify file system objects.
         *
         * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
         *
         * A new instance of File can be created from a String that contains a file system path
         */
        File pwd = new File("unsorted.txt");
        System.out.println(pwd.getAbsolutePath());
        System.out.println("Exists? " + pwd.exists());
        System.out.println("Is Directory? " + pwd.isDirectory());
        System.out.println("Is Regular File? " + pwd.isFile());
        System.out.println("Size: " + pwd.length());

//		File tempDir = new File("./temp");
//		if (!tempDir.exists()) {
//			Files.createDirectory(tempDir.toPath());
//			System.out.println("Created temp folder");
//		} else {
//			System.out.println("temp folder already exists");
//		}

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

        try (Scanner inputFile = new Scanner(new File("unsorted.txt"));
             PrintWriter outputFile = new PrintWriter("sorted.txt");
             PrintWriter logFile = new PrintWriter(new FileWriter("log.txt", true))) {

            String formattedDate = dateFormatter.format(LocalDateTime.now());
            logFile.println(formattedDate + " - Program started");

            // Copies the inputFile to the outputFile line by line
//			while (inputFile.hasNextLine()) {
//                outputFile.println(inputFile.nextLine());
//            }

            List<String> inputLines = new ArrayList<>();
            while (inputFile.hasNextLine()) {
                String inputLine = inputFile.nextLine();
                inputLines.add(inputLine);
            }

            Collections.sort(inputLines);

            for (String inputLine : inputLines) {
                outputFile.println(inputLine);
                //appendingOutputFile.println(inputLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error creating file");
        } catch (IOException e) {
            System.out.println("Caught an IOException. Message: " + e.getMessage());
        }

    }

}
