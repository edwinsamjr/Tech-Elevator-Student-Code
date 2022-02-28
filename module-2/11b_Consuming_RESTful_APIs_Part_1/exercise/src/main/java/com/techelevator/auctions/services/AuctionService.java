package com.techelevator.auctions.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static final String API_BASE_URL = "http://localhost:3000/auctions/";
    private final RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
        Auction[] auctions = this.restTemplate.getForObject(API_BASE_URL, Auction[].class);
        return auctions;
    }

    public Auction getAuction(int id) {
        final String url = API_BASE_URL + id;
        Auction auction = this.restTemplate.getForObject(url, Auction.class);
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        final String url = API_BASE_URL + "?title_like=" + title;
        Auction[] auctions = this.restTemplate.getForObject(url, Auction[].class);
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        final String url = API_BASE_URL + "?currentBid_lte=" + price;
        Auction[] auctions = this.restTemplate.getForObject(url, Auction[].class);
        return auctions;
    }

}
