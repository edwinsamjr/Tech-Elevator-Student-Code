package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        final String url = API_BASE_URL + "hotels";
        return this.restTemplate.getForObject(url, Hotel[].class);
    }

    public Review[] listReviews() {
        final String url = API_BASE_URL + "reviews";
        return this.restTemplate.getForObject(url, Review[].class);
    }

    public Hotel getHotelById(int id) {
        final String url = API_BASE_URL + "hotels/" + id;
        return this.restTemplate.getForObject(url, Hotel.class);
    }

    public Review[] getReviewsByHotelId(int hotelID) {
     final String url = API_BASE_URL + "hotels/" + hotelID + "/reviews";
     // http://loalhost:3000/hotels/1/reviews
     return this.restTemplate.getForObject(url, Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        final String url = API_BASE_URL + "hotels?stars=" + stars;
        return this.restTemplate.getForObject(url, Hotel[].class);

    }

    public City getWithCustomQuery() {
        return null;
    }

}
