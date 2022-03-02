package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    @GetMapping
    public List<Auction> list(
            @RequestParam(required = false) String title_like,
            @RequestParam(required = false) Double currentBid_lte
    ) {
        boolean hasTitleCriteria = title_like != null;
        boolean hasCurrentBidCriteria = currentBid_lte != null && currentBid_lte > 0.0;

        List<Auction> auctions = new ArrayList<>();

        if (!hasTitleCriteria && !hasCurrentBidCriteria) {
            auctions = this.dao.list();
        } else if (hasTitleCriteria && !hasCurrentBidCriteria) {
            auctions = this.dao.searchByTitle(title_like);
        } else if (!hasTitleCriteria && hasCurrentBidCriteria) {
            auctions = this.dao.searchByPrice(currentBid_lte);
        } else if (hasTitleCriteria && hasCurrentBidCriteria) {
            auctions = this.dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }

        return auctions;
    }

    @GetMapping (path = "/{id}")
    public Auction get(@PathVariable int id) {
        Auction auction = this.dao.get(id);
        return auction;
    }

    @PostMapping
    public Auction create(@RequestBody Auction newAuction) {
        Auction auction = this.dao.create(newAuction);
        return auction;
    }

}
