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

    private static final BigDecimal MINI_BAR_FEE = new BigDecimal("12.99");
    private static final BigDecimal CLEANING_FEE = new BigDecimal("34.99");
    private static final BigDecimal FEE_FOR_BAR_AND_CLEANING = MINI_BAR_FEE.add(CLEANING_FEE.multiply(new BigDecimal("2")));

    /**
     *
     * @param name
     * @param numOfNights
     * @throws IllegalArgumentException if name is empty or null or if numOfNights < 1
     */
    public HotelReservation(String name, int numOfNights) {
        this.name = name;
        this.numOfNights = numOfNights;
        this.estimatedTotal = new BigDecimal("59.99").multiply(new BigDecimal(numOfNights));
        if (numOfNights < 1 || name == "" || name == null) {
            throw new IllegalArgumentException();
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
        try {
            HotelReservation hotelReservation = new HotelReservation("Edwin", 2);
            System.out.println(hotelReservation.estimatedTotal);
            hotelReservation.addFees(true, true);
            hotelReservation.addFees(true, true);
            String result = hotelReservation.toString();

            System.out.println(result);

            hotelReservation.calculateRevenue();

        } catch (IllegalArgumentException e) {
            System.out.println("Please enter valid name and number of nights");
        }

    }

    public BigDecimal addFees(boolean usedMinibar, boolean requiresCleaning) {

        if (estimatedTotal.compareTo(new BigDecimal("59.99").multiply(new BigDecimal(numOfNights))) < 1) {

            if (requiresCleaning && usedMinibar) {
                estimatedTotal = estimatedTotal.add(FEE_FOR_BAR_AND_CLEANING);
            } else if (requiresCleaning) {
                estimatedTotal = estimatedTotal.add(CLEANING_FEE);
            } else if (usedMinibar) {
                estimatedTotal = estimatedTotal.add(MINI_BAR_FEE);
            }
        }

        return estimatedTotal;

    }

    @Override
    public String toString() {
        String result = "RESERVATION - {" + name + "} - {" + estimatedTotal + "}";
        return result;

    }

    public void calculateRevenue() {
        List<HotelReservation> reservations = new ArrayList<>();
        BigDecimal currentTotal = new BigDecimal("0.00");

        try (Scanner scanner = new Scanner(new File("C:\\Users\\Student\\workspace\\edwin-sam-jr-student-code\\module-1\\checkpoint\\data-files\\HotelInput.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(",");
                String guestName = splitLine[0];
                String numNightsTrimmed = splitLine[1].trim();
                int guestNumOfNights = Integer.parseInt(numNightsTrimmed);
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
