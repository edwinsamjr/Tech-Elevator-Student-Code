package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FileSplitter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Where is the input file?");
        String inputPath = scanner.nextLine();
        System.out.println("");

        System.out.println("How many lines of text (max) should there be in the split files?");
        String maxLinesStr = scanner.nextLine();
        int maxLinesInt = Integer.parseInt(maxLinesStr);
        System.out.println("");

        File inputFile = new File(inputPath);

        int numInputLines = 0;
        try (Scanner sourceFile = new Scanner(inputFile)) {
            while (sourceFile.hasNextLine()) {
                sourceFile.nextLine();
                numInputLines++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        //Guard against empty input file or file not existing

        int numOutputFiles;
        if (numInputLines % maxLinesInt != 0) {
            numOutputFiles = numInputLines / maxLinesInt + 1;
        } else {
            numOutputFiles = numInputLines / maxLinesInt;
        }

        String inputName = inputFile.getName();
        int indexOfDecimal = inputName.indexOf(".");
        String inputNamePrefix = inputName.substring(0, indexOfDecimal) + "-";

        String inputNameFileExtension = inputName.substring(indexOfDecimal, inputName.length());
        ;

        System.out.printf("For a %d line input file '%s', this produces %d output files.", numInputLines, inputName, numOutputFiles);
        System.out.println("");


        System.out.println("GENERATING OUTPUT FILES");
        try (Scanner sourceFile = new Scanner(inputFile)) {
            int fileNum = 1;
            while (fileNum <= numOutputFiles) {
                String fileCounterString = String.valueOf(fileNum);
                String outputFileName = inputNamePrefix + fileCounterString + inputNameFileExtension;
                try (PrintWriter outputFile = new PrintWriter(outputFileName)) {

                }
                fileNum++;
            }

            int lineCounter = 1;
            fileNum = 1;
            while (sourceFile.hasNextLine()) {

				String fileCounterString = String.valueOf(fileNum);
				String outputFileName = inputNamePrefix + fileCounterString + inputNameFileExtension;
                    try (PrintWriter outputFile = new PrintWriter(new FileWriter(outputFileName, true))) {
                        outputFile.println(sourceFile.nextLine());
                }
                lineCounter++;
				if (lineCounter % maxLinesInt == 1) {
					lineCounter = 1;
					fileNum++;
				}


            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Could not write to file");
        }

        System.out.println("exited loop");


    }


}

