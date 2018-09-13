package stockservice;

import java.math.BigDecimal;
import java.util.Date;
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
        StockQuote quote = new StockQuote(new Date(requestedQuote.getDateRecorded().getTime()), new BigDecimal("342.1"), "APPL");
        assertTrue("The returned quote is correct", requestedQuote.equals(quote));
    }
    
    @Test(expected = MissingResourceException.class)
    public void testNotAppleSymbol() {
        service.getQuote("GOOG");
    }
}
