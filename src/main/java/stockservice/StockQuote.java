package stockservice;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * A class that models a Stock Quote
 * 
 * @author Christopher Stafford
 */
public class StockQuote {
    private String stockSymbol;
    private BigDecimal stockPrice;
    private Calendar dateRecorded;
    
    /**
     * Creates a new StockQuote instance
     * 
     * @param dateRecorded The date in which the stock quote is from as <CODE> Calendar </CODE>
     * @param stockPrice The price of the stock as <CODE>BigDecimal</CODE>
     * @param stockSymbol The Symbol for the stock
     */
    
    public StockQuote(Calendar dateRecorded, BigDecimal stockPrice, String stockSymbol) {
        this.dateRecorded = dateRecorded;
        this.stockPrice = stockPrice;
        this.stockSymbol = stockSymbol;
    }
    
    /**
     * 
     * @return the symbol of the stock 
     */
    public String getStockSymbol() {
        return stockSymbol;
    }
    
    /**
     * 
     * @return the price of the stock as <CODE>BigDecimal</CODE>
     */
    public BigDecimal getStockPrice() {
        return stockPrice;
    }
    
    /**
     * 
     * @return the date the stock quote was requested and returned as <CODE>Date</CODE>
     */
    public Calendar getDateRecorded() {
        return dateRecorded;
    }
    
    /**
     * 
     * @param o An object to compare
     * @return Returns whether or not two <CODE>Stock Quote</CODE> objects are equal as <CODE>boolean</CODE>
     */
    @Override public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StockQuote)){
            return false;
        }
        StockQuote sq = (StockQuote)o;
        return sq.dateRecorded.compareTo(dateRecorded) == 0
            && sq.stockPrice.compareTo(stockPrice) == 0
            && sq.stockSymbol == this.stockSymbol;
    }
    
    /**
     * 
     * @return <CODE>String</CODE> formatted as dateRecordade=value stockPrice=value stockSymbol=value
     */
    @Override public String toString() {
        return "dateRecorded=" + dateRecorded + 
                " stockPrice=" + stockPrice + 
                " stockSymbol=" + stockSymbol +"";
    }
    
    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + (stockSymbol == null ? 0 : stockSymbol.hashCode());
        result = 31 * result + (dateRecorded == null ? 0 : dateRecorded.hashCode());
        result = 31 * result + (stockPrice == null ? 0 : stockPrice.hashCode());
        return result;
    }
}
