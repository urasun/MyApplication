package com.coldsun.myapplication;

public class MyStock {
    String id;
    String name;
    int shares;
    float price; // current price
    float cost;	// cost of buying
    float gain;

    public MyStock() {
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        this.gain = (price - cost) * shares;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;

    }



    public MyStock(String id, int shares, float cost) {
        super();
        this.id = id;
        this.shares = shares;
        this.cost = cost;
    }

    @Override
    public String toString() {

//		return String.format( "ID = %s, NAME = %5s, \tSHARES = %,7d, PRICE = %6.2f,  COST = %6.2f, VAL = %,12.2f, GAIN = %,12.2f, PERCENT = %,6.2f%% ", id, name, shares, price, cost, price * shares, gain, (price - cost)/cost * 100);
        return String.format( "%s %5s \t %,7d %,6.2f %,6.2f %,12f %,12f %,6f%% ", id, name, shares, price, cost, price * shares, gain, (price - cost)/cost * 100);

    }

}
