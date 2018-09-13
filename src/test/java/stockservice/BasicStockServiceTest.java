/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockservice;

import java.util.MissingResourceException;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author chris
 */
public class BasicStockServiceTest {
    private StockService service;
    
    @Before
    public void setup() {
        service = StockServiceFactory.getStockService("Basic");
    }
    
    @Test
    public void testAppleSymbol() {
        StockQuote requestedQuote = service.getQuote("APPL");
        StockQuote quote = new StockQuote(requestedQuote.getDateRecorded(), requestedQuote.getStockPrice(), "APPL");
        assertTrue("The returned quote is correct", requestedQuote.equals(quote));
    }
    
    @Test(expected = MissingResourceException.class)
    public void testNotAppleSymbol() {
        service.getQuote("GOOG");
    }
}
