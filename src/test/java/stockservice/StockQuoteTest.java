/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockservice;

import java.math.BigDecimal;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author chris
 */
public class StockQuoteTest {
    private String stockSymbol;
    private BigDecimal stockPrice;
    private Date dateRecorded;
    private StockQuote quotex;
    private StockQuote quotey;
    private StockQuote quotez;
    private StockQuote quoten;
    
    @Before
    public void setup() {
        stockSymbol = "APPL";
        stockPrice = new BigDecimal("347.1");
        dateRecorded = new Date();
        quotex = new StockQuote(dateRecorded, stockPrice, stockSymbol);
        quotey = new StockQuote(dateRecorded, stockPrice, stockSymbol);
        quotez = new StockQuote(dateRecorded, stockPrice, stockSymbol);
        quoten = new StockQuote(dateRecorded, stockPrice, "GOOG");
    }
    
    @Test
    public void testStockQuoteConstrucion() {
        StockQuote quote = new StockQuote(dateRecorded, stockPrice, stockSymbol);
        
        assertEquals("The date recorded is correct", quote.getDateRecorded(), dateRecorded);
        assertEquals("The stock price is correct", quote.getStockPrice(), stockPrice);
        assertEquals("The stock symbol is correct", quote.getStockSymbol(), stockSymbol);
    }
    
    @Test
    public void testEqualsReflexive() {
        assertTrue(quotex.equals(quotex));
    }
    
    @Test
    public void testEqualsSymmetric() {
        assertTrue(quotex.equals(quotey) && quotey.equals(quotex));
    }
    
    @Test
    public void testEqualsTransitive() {
        assertTrue(quotex.equals(quotey) && quotey.equals(quotez) && quotez.equals(quotex));
    }
    
    @Test
    public void testEqualsNonNull() {
        assertFalse(quotex.equals(null));
    }
    
    @Test
    public void testNotEquals() {
        assertFalse(quotex.equals(quoten));
    }
    
    
    @Test
    public void testHashCodeReflexive() {
        assertTrue(quotex.hashCode() == quotex.hashCode());
    }
    
    @Test
    public void testHashCodeSymmetric() {
        assertTrue(quotex.hashCode() == quotey.hashCode());
    }
    
    @Test
    public void testHashCodeTransitive() {
        assertTrue(quotex.hashCode() == quotey.hashCode() 
                && quotey.hashCode() == quotez.hashCode() 
                && quotez.hashCode() == quotex.hashCode());
    }
    
    @Test
    public void testHashCodeNonZero() {
        assertFalse(quotex.hashCode() == 0);
    }
    
    @Test
    public void testHashCodeDiff() {
        assertFalse(quotex.hashCode() == quoten.hashCode());
    }
    
    @Test
    public void testToString() {
        assertEquals(quotex.toString(), 
            "dateRecorded=" + dateRecorded + 
            " stockPrice=" + stockPrice + 
            " stockSymbol=" + stockSymbol +"");
    }
}
