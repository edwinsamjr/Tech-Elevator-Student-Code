package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {

		Lecture lecture = new Lecture();
		lecture.testAutoBoxing();

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		List<String> names = new ArrayList<>();
		names.add("Dave");
		names.add("Bob");
		names.add("Sarah");

		System.out.println(names.get(2));
		System.out.println(names);

		List<Integer> zipCodes = new ArrayList<>(Arrays.asList(45066, 45750, 45342));
		System.out.println(zipCodes);
		zipCodes.add(45342);
		System.out.println(zipCodes);
		zipCodes.add(0, 10001);
		System.out.println(zipCodes);

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		names.add("Dave");
		System.out.println(names);


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		names.add(0, "Dad");
		System.out.println("number of items in names = " + names.size());

		List<String> planets = new ArrayList<>();
		planets.add("Mercury"); // 0
		planets.add("Venus");   // 1
		planets.add("Earth");   // 2

		for (int i = 0; i < planets.size(); i++) {
			System.out.println(planets.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		planets.remove(1);
		for (int i = 0; i < planets.size(); i++) {
			System.out.println(i + " : " + planets.get(i));
		}

		planets.remove("Earth");
		System.out.println(planets);

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		List<String> boardGames = new ArrayList<>();
		boardGames.add("Catan");
		boardGames.add("7 Wonders");
		boardGames.add("Monopoly");
		boolean foundMonopoly = lecture.doesListContain(boardGames, "Monopoly");
		if (foundMonopoly) {
			System.out.println("Found Monopoly");
		}
		System.out.println(boardGames);

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		int indexOfMonopoly = boardGames.indexOf("Monopoly");
		System.out.println("Found Monopoly at index " + indexOfMonopoly);


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		String[] boardGamesAsArray = boardGames.toArray(new String[0]);


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");
		System.out.println("boardgames before sort: " + boardGames);
		Collections.sort(boardGames);
		System.out.println("boardgames after sort: " + boardGames);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");
		Collections.reverse(boardGames);
		System.out.println("boardgames after reverse: " + boardGames);


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String boardGame : boardGames) {
			System.out.println(boardGame);
		}

		List<Integer> nums = new ArrayList<>(Arrays.asList(123, 456, 789));
		int sum = 0;
		for (Integer num : nums) {
			sum = sum + num;
		}
		System.out.println("sum of numbers is " + sum);

		int[] numsAsArr = new int[] { 123, 456, 789};
		int arraySum = 0;

		for (Integer num : numsAsArr) {
			arraySum += num;
		}

		System.out.println("sum of array is " + arraySum);



	}

	public void testAutoBoxing() {
		System.out.println("In testAutoBoxing");

		Integer x = 5;
		Double PI = 3.14159;
		Double PI2 = PI;

		PI = 5.0;

		System.out.println("PI = " + PI + " and PI2 = " + PI2);


		double dPI = PI;

		if (dPI == PI) {
			System.out.println("dPI equals PI");
		}


	}

	public boolean doesListContain(List<String> listToSearch, String strToFind) {
		listToSearch.add("Some string");
		boolean found = listToSearch.contains(strToFind);
		return found;
	}
}
