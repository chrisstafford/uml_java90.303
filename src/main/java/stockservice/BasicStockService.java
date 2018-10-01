package stockservice;

import java.math.BigDecimal;
import java.util.*;

/**
 * A concrete class that implements the StockService interface
 * 
 * @author Christopher Stafford
 */
public class BasicStockService implements StockService {
    
    /**
     * Method to get StockQuote from service
     * 
     * @param symbol The symobl of the stock to pull
     * @return The full stock quote as <CODE> StockQuote </CODE>
     */
    public StockQuote getQuote(String symbol) {
        StockQuote quote = new StockQuote(Calendar.getInstance(), new BigDecimal("342.1"), "APPL");
        
        if (symbol == "APPL") {
            return quote;
        } else {
            throw new MissingResourceException("Stock symbol not found", "BasicStockService", symbol);
    
        }
    }

    /**
     * Method to return stock history
     *
     * @param symbol The symbol of the stock you'd like to lookup
     * @param from Calendar from date for the range of history
     * @param until Calendar until date for range of history
     * @return List<StockQuote> list of StockQuote objects that meet the requested criteria
     */
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {
        StockQuote quote = new StockQuote(Calendar.getInstance(), new BigDecimal("342.1"), "APPL");
        List<StockQuote> quoteList = new ArrayList<StockQuote>();

        if (symbol == "APPL" && from.before(quote.getDateRecorded()) && until.after(quote.getDateRecorded())) {
            quoteList.add(quote);
        } else {
            throw new MissingResourceException("Record not found", "BasicStockService", symbol);
        }
        return quoteList;
    }


}
