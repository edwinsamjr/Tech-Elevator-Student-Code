package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws IllegalArgumentException {

		Scanner userInput = new Scanner(System.in);

		System.out.println("What is the destination file?");
		String destinationPath = userInput.nextLine();
		System.out.println("");

		File destinationFile = new File(destinationPath);

		try (PrintWriter outputFile = new PrintWriter(destinationFile)) {

			for (int i = 1; i < 301; i++) {
				if (i % 15 == 0) {
					outputFile.println("FizzBuzz");
				} else if (i % 5 == 0 ) {
					outputFile.println("Buzz");
				} else if (i % 3 == 0) {
					outputFile.println("Fizz");
				} else {
					outputFile.println(i);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}





	}

}
