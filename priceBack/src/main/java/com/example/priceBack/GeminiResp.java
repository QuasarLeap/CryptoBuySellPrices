package com.example.priceBack;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)

public class GeminiResp {

    private String bid, ask, last;

    public GeminiResp(){
        
    }

    public GeminiResp(String bid, String ask, String last){
        this.bid = bid;
        this.ask = ask;
        this.last = last;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBid(){
        return bid;
    }

    public void setBid(String bid){
        this.bid = bid;
    }

    public String getAsk(){
        return ask;
    }

    public void setAsk(String ask){
        this.ask = ask;
    }

    @Override
    public String toString(){
        return "Gemini{"+
            "bid='" + bid +'\''+
            ", ask='" + ask + ", last='" + last +
            "'}";
    }
    
}
