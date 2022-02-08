package com.techelevator;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("What is the fully qualified name of the file that should be searched?");
		String path = scanner.nextLine();
		File inputFile = new File(path);

//		if(!inputFile.exists()) {
//			System.out.println(path + " does not exist");
//		} else if (!inputFile.isFile()) {
//			System.out.println(path + " is not a file");
//		}

		try (Scanner fileScanner = new Scanner(inputFile)) {

			int totalQuestions = 0;
			int correctQuestions = 0;

			while (fileScanner.hasNextLine()) {
				String quizQuestion = fileScanner.nextLine();
				String[] quizParts = quizQuestion.split("\\|");
				for (String quizPart : quizParts) {
					if (quizPart.contains("*")) {
						System.out.println(quizPart.substring(0, quizPart.length()-1));
					} else {
						System.out.println(quizPart);
					}
				}

				System.out.print("Your Answer: ");
				String answer = scanner.nextLine();
				boolean isAnswerValid = isAnswerValid(answer);


				if (!isAnswerValid){
					throw new IllegalArgumentException();
				} else {
					boolean answeredCorrectly = false;
					for (String quizPart : quizParts) {

						if (quizPart.contains("*") && quizPart.substring(1, 2).equals(answer)) {
							answeredCorrectly = true;
							correctQuestions++;
						}
					}

					if (answeredCorrectly) {
						System.out.println("CORRECT!");
						System.out.println("");
					} else {
						System.out.println("INCORRECT!");
						System.out.println("");
					}

					totalQuestions++;
				}

			}

			System.out.printf("You got %d answer(s) correct out of the %d" + " questions asked.", correctQuestions, totalQuestions);


		}catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IllegalArgumentException e) {
			System.out.println("Answer not valid");
		}

	}

	public static boolean isAnswerValid(String answer) {
		boolean answerNotOne = !answer.equals("1");
		boolean answerNotTwo = !answer.equals("2");
		boolean answerNotThree = !answer.equals("3");
		boolean answerNotFour = !answer.equals("4");
		boolean answerInvalid = answerNotOne && answerNotTwo && answerNotThree && answerNotFour;

		if (answerInvalid) {
			return false;
		} else {
			return true;
		}
	}

}
