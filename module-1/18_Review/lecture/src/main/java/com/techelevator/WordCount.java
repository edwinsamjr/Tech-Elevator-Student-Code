package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class WordCount {

    public static void main(String[] args) {
        WordCount wordCount = new WordCount();
        wordCount.run();
    }


    public void run() {
        File inputFile = getFileFromUser();

        int numLines = 0;
        int numWords = 0;

//        //Old way
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
//            System.out.println(e.getMessage());
//        } finally {
//            inputFileScanner.close();
//            log.close();
//        }

        try (Scanner inputFileScanner = new Scanner(inputFile);
             PrintWriter log = new PrintWriter("log.txt")) {

            while (inputFileScanner.hasNextLine()) {
                numLines++;
                String line = inputFileScanner.nextLine();
                String[] words = line.split(" ");
                numWords += words.length;

                System.out.printf("%3d : [%s]%n", words.length, line);;
            }



        } catch (FileNotFoundException e) {
            System.out.println("Error opening files. Msg: " + e.getMessage());
        }

        System.out.printf("The file %s contains %d lines and %d words%n", inputFile.getName(), numLines, numWords);;

    }

    private File getFileFromUser() {
        File inputFile = null;
        Scanner inputReader = new Scanner(System.in);
        boolean receivedValidInput = false;

        do {
            System.out.println("Please enter file name:");
            String inputFileName = inputReader.nextLine();

            inputFile = new File(inputFileName);

            if (!inputFile.exists()) {
                System.out.printf("%s doesn't exist%n", inputFile);
            } else if (!inputFile.isFile()) {
                System.out.printf("%s isn't a File");
            } else {
                receivedValidInput = true;
            }

        } while (!receivedValidInput);

        return inputFile;
    }

}
