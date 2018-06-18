package com.paultan.controllers;

import java.util.List;
import java.util.HashMap;
import java.util.Date;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paultan.model.Auction;
import com.paultan.model.Bid;
import com.paultan.model.User;
import com.paultan.model.Product;

@RestController 
@RequestMapping("auction")
public class AuctionController {
    
    HashMap<String, Auction> auctions;

    public AuctionController(){
	this.auctions = new HashMap();
	//TODO: The auctions hashmap should be populated in another manner:
	Product p1 = new Product("p1", "toy");
	Product p2 = new Product("p2", "shirt");
	
	Auction a1 = new Auction();
	a1.setId("a1");
	a1.setProduct(p1);
	Auction a2 = new Auction();
	a1.setId("a2");
	a1.setProduct(p2);
	auctions.put(a1.getId(),a1);
	auctions.put(a2.getId(),a2);
    }

    @RequestMapping(value="/{AuctionId}", method = RequestMethod.GET)
    public Auction getAuctionById(@PathVariable("AuctionId")String AuctionId) {
	return auctions.get(AuctionId);
    }

    @RequestMapping(value="/start", method = RequestMethod.GET)
    public void start() {
	Date now = new Date();
	for (Auction a:auctions.values())
	    a.setStartTime(now);
    }

    @RequestMapping(value="/end", method = RequestMethod.GET)
    public void end() {
	Date now = new Date();
	for (Auction a:auctions.values())
	    {
		a.setEndTime(now);
		//print winning user,bids
		if (a.getBids()!=null && a.getBids().size()>0)
		    {
			Bid winningBid = a.getBids().get(a.getBids().size()-1);
			System.out.println("winning bidder userId="+winningBid.getUser().getId()+" amount="+
					   winningBid.getAmount());
		    }
		else
		    System.out.println("No bids for auction "+a);
	    }
    }

    @RequestMapping(value="/bid/{productId}/{userId}/{bidAmount}", method = RequestMethod.GET)
    public void placeBid(@PathVariable("productId")String productId,
			 @PathVariable("userId")String userId,
			 @PathVariable("bidAmount")double bidAmount) {
	Auction auction = auctions.get(productId);
	Date now = new Date();
	if (auction.getEndTime().getTime() < now.getTime() &&
	    auction.getStartTime().getTime() > now.getTime())
	    {
		if (auction.getBids()==null)
		    auction.setBids(new ArrayList());

		User u = new User();
		u.setId(userId);
		Bid  b = new Bid();
		b.setProductId(productId);
		b.setUser(u);
		b.setAmount(bidAmount);
		    
		//get last bid
		if (auction.getBids().size() > 0)
		    {
			Bid bid = auction.getBids().get(auction.getBids().size()-1);
			if (bid.getAmount() < bidAmount){
			    auction.getBids().add(b);
			}    
		    }
		else
		    auction.getBids().add(b);
		
	    }
    }
   
}
