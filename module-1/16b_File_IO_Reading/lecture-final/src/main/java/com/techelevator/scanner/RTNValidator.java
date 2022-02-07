package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {

	// PNC Routing number                                     0  4  1  0  0  0  1  2  4
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };
	//                                                        0 28  1  0  0  0  3 14  4   Sum = 50. 50 mod 10 = 0 Valid

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();
		
		File inputFile = getInputFileFromUser();
		//Scanner fileScanner; <- Doesn't work
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				if (line.length() < 9) {
					System.out.println(line);
				} else {
					String rtn = line.substring(0, 9);

					if (checksumIsValid(rtn) == false) {
						System.out.println(line);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		String quizQuestion = "What is 2 + 2?|4*|2|9|who knows";

		String[] quizParts = quizQuestion.split("\\|");

		for (String quizPart : quizParts) {
			System.out.println(quizPart);
		}


	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
//		if(inputFile.exists() == false) { // checks for the existence of a file
//			System.out.println(path+" does not exist");
//			System.exit(1); // Ends the program
//		} else if(inputFile.isFile() == false) {
//			System.out.println(path+" is not a file");
//			System.exit(1); // Ends the program
//		}
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		try {
			int checksum = 0;
			for (int i = 0; i < 9; i++) {
				int digit = Integer.parseInt(routingNumber.substring(i, i + 1));
				checksum += digit * CHECKSUM_WEIGHTS[i];
			}
			return checksum % 10 == 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
