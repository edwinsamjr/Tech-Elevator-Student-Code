package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class BufferedReaderWordCount {

    public static void main(String[] args) {
        BufferedReaderWordCount wordCount = new BufferedReaderWordCount();
        wordCount.run();
    }

    public void run() {
        File inputFile = getFileFromUser();

        int numLines = 0;
        int numWords = 0;

        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));
             BufferedWriter log = new BufferedWriter(new FileWriter("log.txt"))) {

            // BufferedWriter doesn't have any type of println(...) method. The code below writes a
            // String and then the system specific "end of line" indicator: a linefeed (\n) on Unix
            // based systems like Macs, or a carriage return and linefeed (\r\n) on Windows
            log.write("Processing started" + System.lineSeparator());

            String line;
            while ((line = inputReader.readLine()) != null) {
                numLines++;
                String[] words = line.split(" ");
                numWords += words.length;

                // TODO - Remove this once we're done
                System.out.format("%3d : [%s]%n", words.length, line);
            }

            log.write("Processing finished" + System.lineSeparator());

        } catch (FileNotFoundException e) {
            System.out.println("Error opening files. Msg: " + e.getMessage());
        } catch (IOException e) {
            System.out.printf("Error opening files. Msg: " + e.getMessage());
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
