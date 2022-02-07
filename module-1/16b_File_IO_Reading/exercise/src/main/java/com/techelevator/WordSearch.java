package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordSearch {



	public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("What is the fully qualified name of the file that should be searched?");
		String path = scanner.nextLine();
		File inputFile = new File(path);

		if(!inputFile.exists()) {
			System.out.println(path + " does not exist");
		} else if (!inputFile.isFile()) {
			System.out.println(path + " is not a file");
		}


		System.out.println("What is the search word you are looking for?");
		String testWord = scanner.nextLine();

		System.out.println("Should the search be case sensitive? (Y\\N)");
		String caseSensitivityAnswer = scanner.nextLine();
		boolean isCaseSensitive = caseSensitivityAnswer.equals("Y");
		boolean answerNotYOrN = !caseSensitivityAnswer.equals("Y") && !caseSensitivityAnswer.equals("N");




		try(Scanner fileScanner = new Scanner(inputFile)) {

			int lineCounter = 1;

			if (answerNotYOrN) {
				throw new IllegalArgumentException();
			} else if (isCaseSensitive) {

				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					boolean hasSearchWord = false;
					for (int i = 0; i < line.length() - testWord.length(); i++) {
						if (line.substring(i, i + testWord.length()).equals(testWord)) {
							hasSearchWord = true;
						}
					}
					if (line.length() >= 3 && hasSearchWord) {
						System.out.println(lineCounter + ") " + line);
					}


					lineCounter++;

				}
			} else {
				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					boolean hasSearchWord = false;
					for (int i = 0; i < line.length() - testWord.length(); i++) {
						if (line.substring(i, i + testWord.length()).equalsIgnoreCase(testWord)) {
							hasSearchWord = true;
						}
					}
					if (line.length() >= 3 && hasSearchWord) {
						System.out.println(lineCounter + ") " + line);
					}


					lineCounter++;

				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IllegalArgumentException e) {
			System.out.println("Y or N not entered");
		}


	}



}
