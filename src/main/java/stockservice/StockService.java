package stockservice;

import java.util.Calendar;
import java.util.List;

/**
 * Interface for accessing StockQuotes from a given service
 * 
 * @author Christopher Stafford
 */
public interface StockService {
    /**
     * Return the current price for a share of stock for the given symbol
     * @param symbol the stock symbol of the company you want the quote for
     *        e.g. APPL for APPLE
     * @return a <CODE>StockQuote</CODE> instance
     */
    StockQuote getQuote(String symbol);

    /**
     * Get a historical list of stock quotes for the provided
     * symbol
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances.
     * One for each day in the range specified.
     */
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until);
}
