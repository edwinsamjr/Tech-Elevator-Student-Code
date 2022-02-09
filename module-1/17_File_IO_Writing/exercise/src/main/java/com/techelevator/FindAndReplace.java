package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {


    /**
     *
     * @param args
     * @throws IllegalArgumentException, FileNotFoundException
     */
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();
        System.out.println("");

        System.out.println("What is replacement word?");
        String replacementWord = userInput.nextLine();
        System.out.println("");

        System.out.println("What is the source file?");
        String sourcePath = userInput.nextLine();
        System.out.println("");

        System.out.println("What is destination file?");
        String destinationPath = userInput.nextLine();

        boolean hasNullInput = (searchWord == null || replacementWord == null || sourcePath == null || destinationPath == null);
        boolean bothFilesExist = (new File(sourcePath).exists() && new File(destinationPath).exists());
        boolean bothFilesAreFiles = new File(sourcePath).isFile() && new File(destinationPath).isFile();

        if (bothFilesAreFiles && bothFilesExist && !hasNullInput) {

            try (Scanner sourceFile = new Scanner(new File(sourcePath));
                 PrintWriter destinationFile = new PrintWriter(destinationPath)) {
                while (sourceFile.hasNextLine()) {
                    String originalLine = sourceFile.nextLine();
                    String replacementLine = originalLine.replaceAll(searchWord, replacementWord);
                    destinationFile.println(replacementLine);

                }


            }
            catch (FileNotFoundException e) {
                System.out.println("File not found");
            }

        } else {
            System.out.println("Not given two valid files");
        }


    }

}
