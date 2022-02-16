package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

	private String name;
	private int numOfNights;
	private BigDecimal estimatedTotal;

	public HotelReservation(String name, int numOfNights) {
		this.name = name;
		this.numOfNights = numOfNights;
		try {
			this.estimatedTotal = new BigDecimal("59.99").multiply(new BigDecimal(numOfNights));
			if (numOfNights < 1 || name == "" || name == null ) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Please enter a valid name & number of nights");
			System.exit(12345);
		}
	}

	public String getName() {
		return name;
	}

	public int getNumOfNights() {
		return numOfNights;
	}

	public BigDecimal getEstimatedTotal() {
		return estimatedTotal;
	}

	public static void main(String[] args) {

		HotelReservation hotelReservation = new HotelReservation("Edwin", 1);
		hotelReservation.addFees(true, true);
		String result = hotelReservation.toString();

		System.out.println(result);

		hotelReservation.calculateRevenue();

	}

	public  BigDecimal addFees(boolean usedMinibar, boolean requiresCleaning) {
		BigDecimal miniBarFee = new BigDecimal("12.99");
		BigDecimal cleaningFee = new BigDecimal("34.99");
		BigDecimal feeForBarAndCleaning = miniBarFee.add(cleaningFee.multiply(new BigDecimal("2")));
		if(requiresCleaning && usedMinibar) {
			estimatedTotal = estimatedTotal.add(feeForBarAndCleaning);
		} else if (requiresCleaning) {
			estimatedTotal = estimatedTotal.add(cleaningFee);
		} else if (usedMinibar) {
			estimatedTotal = estimatedTotal.add(miniBarFee);
		}

		return estimatedTotal;

	}

	@Override
	public String toString() {
		String result = "RESERVATION - {" + name + "} - {" + estimatedTotal + "}";
		return result;

	}

	//Adjusted the HotelInput CSV to take out spaces after commas in lines 2-5
	public void calculateRevenue() {
		List<HotelReservation> reservations = new ArrayList<>();
		BigDecimal currentTotal = new BigDecimal("0.00");

		try (Scanner scanner = new Scanner(new File ("C:\\Users\\Student\\workspace\\edwin-sam-jr-student-code\\module-1\\checkpoint\\data-files\\HotelInput.csv"))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] splitLine = line.split(",");
				String guestName = splitLine[0];
				int guestNumOfNights = Integer.parseInt(splitLine[1]);
				reservations.add(new HotelReservation(guestName, guestNumOfNights));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		for (HotelReservation reservation : reservations) {
			currentTotal = currentTotal.add(reservation.getEstimatedTotal());
		}

		System.out.println(currentTotal);

	}

}
