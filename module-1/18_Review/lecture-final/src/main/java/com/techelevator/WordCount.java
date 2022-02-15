package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {
        WordCount wordCount = new WordCount();
        wordCount.run();
    }

    public void run() {
        File inputFile = getFileFromUser();

        int numLines = 0;
        int numWords = 0;

//        Scanner inputFileScanner = null;
//        PrintWriter log = null;
//        try {
//            inputFileScanner = new Scanner(inputFile);
//            log = new PrintWriter("log.txt");
//
//            while (inputFileScanner.hasNextLine()) {
//                numLines++;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Shouldn't happen");
//        } finally {
//            inputFileScanner.close();
//            if (log != null) {
//                log.close();
//            }
//        }

        try (Scanner inputFileScanner = new Scanner(inputFile);
             PrintWriter log = new PrintWriter("log.txt")) {

            while (inputFileScanner.hasNextLine()) {
                numLines++;
                String line = inputFileScanner.nextLine();
                String[] words = line.split(" ");
                numWords += words.length;

                // TODO - Remove this once we're done
                System.out.format("%3d : [%s]%n", words.length, line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening files. Msg: " + e.getMessage());
        }

        System.out.format("The file %s contains %d lines and %d words%n", inputFile.getAbsoluteFile(), numLines, numWords);
    }

    private File getFileFromUser() {
        File inputFile;
        Scanner inputReader = new Scanner(System.in);
        boolean receivedValidInput = false;

        do {
            System.out.print("Please enter a filename: ");
            String inputFileName = inputReader.nextLine();

            inputFile = new File(inputFileName);

            if (!inputFile.exists()) {
                System.out.format("%s doesn't exist%n", inputFileName);
            } else if (!inputFile.isFile()) {
                System.out.format("%s is not a file", inputFileName);
            } else {
                receivedValidInput = true;
            }
        } while (!receivedValidInput);

        return inputFile;
    }
}
