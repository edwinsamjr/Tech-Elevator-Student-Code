package com.techelevator;

import java.util.List;

public class ReserveAuction extends Auction {

    private int reserveAmount;

    // Not required. Inherited from the base (parent) class Auction
//    private String itemForSale;
//    private Bid currentHighBid;
//    private List<Bid> allBids;

    public ReserveAuction(String itemForSale, int reserveAmount) {
        super(itemForSale);
        this.reserveAmount = reserveAmount;
    }

    public int getReserveAmount() {
        return this.reserveAmount;
    }

    @Override
    public boolean placeBid(Bid reserveAuctionBid) {
        if (reserveAuctionBid.getBidAmount() < this.reserveAmount) {
            // Bid doesn't exceed or equal reserve amount
            return false;
        }

        return super.placeBid(reserveAuctionBid);
    }

    public boolean placeWinningBid(String bidder) {
        //Bid currentHighest = this.getHighBid();
        //Bid currentHighest = super.getHighBid();
        Bid currentHighest = getHighBid();

        return placeBid(new Bid(bidder, currentHighest.getBidAmount() + 1));
    }
}
