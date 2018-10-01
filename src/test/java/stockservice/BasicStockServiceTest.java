package stockservice;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    private String symbol;
    private Calendar from;
    private Calendar until;

    @Before
    public void setup() {
        service = StockServiceFactory.getStockService();
        symbol = "APPL";
        from = Calendar.getInstance();
        until = Calendar.getInstance();
        from.add(Calendar.DATE, -10);
        until.add(Calendar.DATE, 10);
    }
    
    @Test
    public void testAppleSymbol() {
        StockQuote requestedQuote = service.getQuote(symbol);
        StockQuote quote = new StockQuote(requestedQuote.getDateRecorded(), new BigDecimal("342.1"), symbol);
        assertTrue("The returned quote is correct", requestedQuote.equals(quote));
    }

    @Test
    public void testAppleSymbolList() {
        List<StockQuote> requestedQuote = service.getQuote(symbol, from, until);
        StockQuote quote = new StockQuote(requestedQuote.get(0).getDateRecorded(), new BigDecimal("342.1"), symbol);
        assertTrue("The returned quote is correct", requestedQuote.get(0).equals(quote));
    }

    @Test(expected = MissingResourceException.class)
    public void testNotAppleSymbol() {
        service.getQuote("GOOG");
    }
}
