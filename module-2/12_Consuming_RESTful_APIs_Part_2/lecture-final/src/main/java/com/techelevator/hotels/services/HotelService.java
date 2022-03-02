package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        final String url = API_BASE_URL + "reservations";

        // content
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Reservation> content = new HttpEntity<>(newReservation, headers);

        // send to the api
        return this.restTemplate.postForObject(url, content, Reservation.class);
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        final String url = API_BASE_URL + "reservations/" + updatedReservation.getId();

        // content
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Reservation> content = new HttpEntity<>(updatedReservation, headers);

        this.restTemplate.put(url, content);
        return true;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {
        final String url = API_BASE_URL + "reservations/" + id;
        try {
            this.restTemplate.delete(url);
            return true;
        } catch (RestClientResponseException cre) {
            BasicLogger.log(cre.getMessage());
            return false;
        } catch (ResourceAccessException ae) {
            // retry?
            BasicLogger.log(ae.getMessage());
            return false;
        }

//        final String url = API_BASE_URL + "reservations/{id}";
//        Map<String, String> params = new HashMap<>();
//        params.put("id", Integer.toString(id));
//        this.restTemplate.delete(url, params);
    }

    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}