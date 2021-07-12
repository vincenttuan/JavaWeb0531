package com.web.tag.utils;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MyStock {
    private static final String RED = "#FF0000";
    private static final String GREEN = "#005100";
    private static final String BLACK = "#000000";
    private String symbol;
    private String name;
    private Double price;
    private Double change;
    private String color;

    public MyStock() {
    }

    public MyStock(String symbol) {
        setSymbol(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        try {
            Stock stock = YahooFinance.get(symbol);
            this.name = stock.getName();
            this.price = stock.getQuote().getPrice().doubleValue();
            this.change = stock.getQuote().getChangeInPercent().doubleValue();
            this.color = (this.change > 0) ? RED : (this.change < 0) ? GREEN : BLACK;
        } catch (Exception e) {
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
