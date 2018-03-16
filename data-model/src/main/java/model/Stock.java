package model;

import java.sql.Timestamp;

public class Stock {

    public Stock(Number id, String name, Amount currentPrice){
        this.id=id;
        this.name=name;
        this.currentPrice=currentPrice;
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        this.lastUpdate=timestamp;
    }

    private Number id;
    private String name;
    private Amount currentPrice;
    private Timestamp lastUpdate;

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Amount currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
