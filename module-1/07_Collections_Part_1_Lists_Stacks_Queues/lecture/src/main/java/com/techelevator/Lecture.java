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
		names.add("Edwin");
		names.add("Nicholas");
		names.add("Colin");

		System.out.println(names.get(0));
		System.out.println(names);

		List<Integer> zipCodes = new ArrayList<>(Arrays.asList(45066, 45750, 45342));
		System.out.println(zipCodes);

		zipCodes.add(1, 45122);
		System.out.println(zipCodes);

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		System.out.println("Number of items in names is " + names.size());

		List<String> planets = new ArrayList<>(Arrays.asList("Mercury", "Venus", "Earth"));

		for (int i = 0; i < planets.size(); i++) {
			System.out.println(planets.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		planets.remove(1);
		System.out.println(planets);

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		List<String> boardGames = new ArrayList<>();
		boardGames.add("Monopoly");
		boardGames.add("Scrabble");
		boardGames.add("Ticket to Ride");
		boardGames.add("Boggle");

		boolean foundMonopoly = lecture.doesListContain(boardGames, "Monopoly");
		if (foundMonopoly) {
			System.out.println("Found Monopoly");
		}
		System.out.println(boardGames);

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexofMonopoly = boardGames.indexOf("Monopoly");
		System.out.println("Found Monopoly at index: " + indexofMonopoly);

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

		for ( String boardGame : boardGames ) {
			System.out.println(boardGame);
		}

		List<Integer> nums = new ArrayList<>(Arrays.asList(123, 456, 7890));
		int sum = 0;
		for (Integer number : nums) {
			sum += number;
		}
		System.out.println(sum);


	}

	public void testAutoBoxing() {
		System.out.println("In testAutoboxing");

		Integer x = 5;
		Double PI = 3.14159;

		double dPI = PI;

		if (dPI == PI) {
			System.out.println("dPI equals PI");
		}

	}

	public boolean doesListContain(List<String> listToSearch, String strToFind) {
		listToSearch.add("Some string");
		return listToSearch.contains(strToFind);
	}

}
