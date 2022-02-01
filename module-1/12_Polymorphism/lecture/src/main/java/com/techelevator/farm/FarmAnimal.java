package com.techelevator.farm;

import java.math.BigDecimal;

public class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private BigDecimal price;

	public FarmAnimal(String name, String sound, BigDecimal price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

	public String getAOrAn() {
//		String[] vowels = new String[] {"A", "E", "I", "O", "U"};
//		for (String vowel : vowels) {
//			if (getSound().toUpperCase().substring(0,1).equals(vowel)) {
//				return "an";
//			}
//		}

		return "a";
	}


	public BigDecimal getPrice() {
		return price;
	}
}