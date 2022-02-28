package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        final String url = API_BASE_URL + "hotels/";
        Hotel[] hotels = this.restTemplate.getForObject(url, Hotel[].class);
        return hotels;
    }

    public Review[] listReviews() {
        final String url = API_BASE_URL + "reviews/";
        Review[] reviews = this.restTemplate.getForObject(url, Review[].class);
        return reviews;
    }

    public Hotel getHotelById(int id) {
        final String url = API_BASE_URL + "hotels/" + id;
        Hotel hotel = this.restTemplate.getForObject(url, Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        final String url = API_BASE_URL + "hotels/" + hotelID + "/reviews";
        Review[] reviews = this.restTemplate.getForObject(url, Review[].class);
        return reviews;
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        final String url = API_BASE_URL + "hotels?stars=" + stars;
        Hotel[] hotels = this.restTemplate.getForObject(url, Hotel[].class);
        return hotels;
    }

    public City getWithCustomQuery(){
        return null;
    }

}
