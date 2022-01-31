package com.techelevator;

import java.util.List;

public class ReserveAuction extends Auction {

    private int reserveAmount;

    public ReserveAuction(String itemForSale, int reserveAmount) {
        super(itemForSale);
        this.reserveAmount = reserveAmount;
    }

    public int getReserveAmount(){
        return this.reserveAmount;
    }

    @Override
    public boolean placeBid(Bid reserveAuctionBid) {
        if (reserveAuctionBid.getBidAmount() < reserveAmount) {
            return false;
        } else {
            return super.placeBid(reserveAuctionBid);
        }
    }

}
