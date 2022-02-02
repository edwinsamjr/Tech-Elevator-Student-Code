package com.techelevator.farm;

import com.techelevator.farm.shape.Rectangle;

public class OldMacdonald {
	public static void main(String[] args) {

		Rectangle rect = new Rectangle(10, 5);
		//int numInst = rect... <!-- Can't access protected Shape method here

		// FarmAnimal can't be instantiated (on the right side of new) now because it's abstract
		//FarmAnimal watermelon = new FarmAnimal("Watermelon", "Splat!");

		Cow cow = new Cow();
		cow.setAsleep(true);
		FarmAnimal chicken = new Chicken();
		chicken.setAsleep(true);
		Cat cat = new Cat();
		cat.setAsleep(true);

		Singable[] singables =
				new Singable[] {cow, chicken, new Pig(), new Tractor(), cat };

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}

		FarmAnimal[] favFoods = new FarmAnimal[] { new Cow(), new Chicken() };
		for (FarmAnimal animal : favFoods) {
			System.out.format("%s favorite food is %s%n", animal.getName(), animal.getFavoriteFood());
		}
	}
}