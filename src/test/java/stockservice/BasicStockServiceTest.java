package stockservice;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;

import static org.junit.Assert.assertEquals;
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
    private IntervalEnum interval;

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
    @Test
    public void testAppleSymbolListIntervalDaily() {
        interval = IntervalEnum.DAILY;
        List<StockQuote> requestedQuote = service.getQuote(symbol, from, until, interval);
        int recordsToReturn = until.get(Calendar.DAY_OF_YEAR) - from.get(Calendar.DAY_OF_YEAR) + 1;
        assertEquals("The number of returned quote is correct, daily", recordsToReturn, requestedQuote.size());
    }
    @Test
    public void testAppleSymbolListIntervalWeekly() {
        interval = IntervalEnum.WEEKLY;
        List<StockQuote> requestedQuote = service.getQuote(symbol, from, until, interval);
        int recordsToReturn = until.get(Calendar.WEEK_OF_YEAR) - from.get(Calendar.WEEK_OF_YEAR) + 1;
        assertEquals("The number of returned quote is correct, weekly", recordsToReturn, requestedQuote.size());
    }
    @Test
    public void testAppleSymbolListIntervalMonthly() {
        interval = IntervalEnum.MONTHLY;
        List<StockQuote> requestedQuote = service.getQuote(symbol, from, until, interval);
        int recordsToReturn = until.get(Calendar.MONTH) - from.get(Calendar.MONTH) + 1;
        assertEquals("The number of returned quote is correct, monthly", recordsToReturn, requestedQuote.size());
    }
    @Test
    public void testAppleSymbolListIntervalAnnually() {
        interval = IntervalEnum.ANNUALLY;
        List<StockQuote> requestedQuote = service.getQuote(symbol, from, until, interval);
        int recordsToReturn = until.get(Calendar.YEAR) - from.get(Calendar.YEAR) + 1;
        assertEquals("The number of returned quote is correct, annually", recordsToReturn, requestedQuote.size());
    }
    @Test(expected = MissingResourceException.class)
    public void testNotAppleSymbol() {
        service.getQuote("GOOG");
    }
}
