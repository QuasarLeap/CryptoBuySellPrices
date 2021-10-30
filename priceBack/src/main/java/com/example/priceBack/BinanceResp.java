package com.example.priceBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class BinanceResp {
    
    private String symbol, bidPrice, askPrice;

    public BinanceResp(){
        
    }

    public BinanceResp(String symbol, String bidPrice, String askPrice){
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    public String getSymbol(){
        return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getBidPrice(){
        return bidPrice;
    }

    public void setBidPrice(String bidPrice){
        this.bidPrice = bidPrice;
    }

    public String getAskPrice(){
        return askPrice;
    }

    public void setAskPrice(String askPrice){
        this.askPrice = askPrice;
    }

    @Override
    public String toString(){
        return "Binance{"+
            "symbol='" + symbol + '\''+
            ", bidPrice='" + bidPrice +'\''+
            ", askPrice='" + askPrice +
            "'}";
    }

}
