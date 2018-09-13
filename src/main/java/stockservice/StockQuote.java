/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockservice;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author chris
 */
public class StockQuote {
    private String stockSymbol;
    private BigDecimal stockPrice;
    private Date dateRecorded;
    
    public StockQuote(Date dateRecorded, BigDecimal stockPrice, String stockSymbol) {
        this.dateRecorded = dateRecorded;
        this.stockPrice = stockPrice;
        this.stockSymbol = stockSymbol;
    }
    
    public String getStockSymbol() {
        return stockSymbol;
    }
    
    public BigDecimal getStockPrice() {
        return stockPrice;
    }
    
    public Date getDateRecorded() {
        return dateRecorded;
    }
    
    @Override public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StockQuote)){
            return false;
        }
        StockQuote sq = (StockQuote)o;
        return sq.dateRecorded == this.dateRecorded
            && sq.stockPrice == this.stockPrice
            && sq.stockSymbol == this.stockSymbol;
    }
    
    @Override public String toString() {
        return "dateRecorded=" + dateRecorded + 
                " stockPrice=" + stockPrice + 
                " stockSymbol=" + stockSymbol +"";
    }
    // TODO @Override pubilc int hashCode
    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + (stockSymbol == null ? 0 : stockSymbol.hashCode());
        result = 31 * result + (dateRecorded == null ? 0 : dateRecorded.hashCode());
        result = 31 * result + (stockPrice == null ? 0 : stockPrice.hashCode());
        return result;
    }
}
