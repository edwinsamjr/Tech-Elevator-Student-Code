package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		Set <String> names = new HashSet<>();


		names.add("Edwin");
		names.add("Nicholas");
		names.add("Colin");

		System.out.println(names.size());

		for ( String name : names ) {
			System.out.println(name);
		}

		Set<Integer> randomNums = new HashSet<>();

		while (randomNums.size() < 50) {
			double randomDouble = Math.random();
			int randomInt = (int) ((randomDouble * 100) + 1);
			if (!randomNums.add(randomInt)) {
				System.out.println("Didn't re-add " + randomInt);
			}
		}

		System.out.println("randomNum size = " + randomNums.size());

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> stateAbbrevs = new HashMap<>() ;
		stateAbbrevs.put("OH", "Ohio");
		stateAbbrevs.put("KY", "Kentucky");
		stateAbbrevs.put("WV", "West Virginia");
		stateAbbrevs.put("HI", "Hawaii");

		String kentucky = stateAbbrevs.get("KY");
		String hawaii = stateAbbrevs.get("HI");

		System.out.println(kentucky);
		System.out.println(hawaii);


		Lecture lecture = new Lecture();
		String result = lecture.getStateName(stateAbbrevs, "ZZ");
		System.out.println(result);

		Set<String> stateKeys = stateAbbrevs.keySet();
		for (String stateKey : stateKeys) {
			System.out.println(stateKey + " : " + stateAbbrevs.get(stateKey));
		}

		// Map of pretend shipping statuses
		Map<Integer, String> statuses = new HashMap<>();
		statuses.put(1, "Order Received");
		statuses.put(2, "Label Printed");
		statuses.put(3, "In Transit");
		statuses.put(4, "Delivered");



	}

	public String getStateName(Map<String, String> states, String stateAbbrev ) {
/*		String stateName = states.get(stateAbbrev);
		if (stateName == null) {
			stateName = "Unknown";
		}*/

		if (states.containsKey(stateAbbrev)){
			return states.get(stateAbbrev);
		} else {
			return "Unknown";
		}

	}

}
