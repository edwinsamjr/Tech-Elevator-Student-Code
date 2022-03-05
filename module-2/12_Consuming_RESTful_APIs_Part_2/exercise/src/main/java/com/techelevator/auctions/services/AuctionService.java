package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

import java.util.stream.BaseStream;

public class AuctionService {

    public static final String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {
        final HttpEntity<Auction> content = makeEntity(newAuction);

        try {
            Auction auction = this.restTemplate.postForObject(API_BASE_URL, content, Auction.class);
            return auction;
        } catch (ResourceAccessException e) {
            System.out.println("Network I/O Problem. Couldn't add auction.");
            BasicLogger.log(e.getMessage());
            return null;
        } catch (RestClientResponseException e) {
            System.out.println("Error adding auction. Code: " + e.getRawStatusCode());
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public boolean update(Auction updatedAuction) {
        String url = API_BASE_URL + updatedAuction.getId();
        final HttpEntity<Auction> content = makeEntity(updatedAuction);
        try {
            this.restTemplate.put(url, content);
            return true;
        } catch (ResourceAccessException e) {
            System.out.println("Network I/O Problem. Couldn't update auction.");
            BasicLogger.log(e.getMessage());
            return false;
        } catch (RestClientResponseException e) {
            System.out.println("Error adding auction. Code: " + e.getRawStatusCode());
            BasicLogger.log(e.getMessage());
            return false;
        }




    }

    public boolean delete(int auctionId) {
        String url = API_BASE_URL + auctionId;
        try {
            this.restTemplate.delete(url);
            return true;
        } catch (ResourceAccessException e) {
            System.out.println("Network I/O Problem. Couldn't delete auction.");
            BasicLogger.log(e.getMessage());
            return false;
        } catch (RestClientResponseException e) {
            System.out.println("Error deleting auction. Code: " + e.getRawStatusCode() );
            BasicLogger.log(e.getMessage());
            return false;
        }
    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}
