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
    @Override
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
    /** Get a historical list of stock quotes for the
     * provide symbol
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param interval the number of StockQuotes to get. E.g. if Interval.DAILY was specified
     *                one StockQuote per day will be returned.
     * @return a list of StockQuote instances. One for each day in the range specified.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval) {
        StockQuote quote = new StockQuote(Calendar.getInstance(), new BigDecimal("342.1"), "APPL");
        List<StockQuote> quoteList = new ArrayList<StockQuote>();
        switch (interval) {
            case DAILY:
                for (int doy = from.get(Calendar.DAY_OF_YEAR); doy <= until.get(Calendar.DAY_OF_YEAR); doy++) {
                    if (symbol == "APPL" && from.before(quote.getDateRecorded()) && until.after(quote.getDateRecorded())) {
                        quoteList.add(quote);
                    } else {
                        throw new MissingResourceException("Record not found", "BasicStockService", symbol);
                    }
                }
                return quoteList;

            case WEEKLY:
                for (int woy = from.get(Calendar.WEEK_OF_YEAR); woy <= until.get(Calendar.WEEK_OF_YEAR); woy++) {
                    if (symbol == "APPL" && from.before(quote.getDateRecorded()) && until.after(quote.getDateRecorded())) {
                        quoteList.add(quote);
                    } else {
                        throw new MissingResourceException("Record not found", "BasicStockService", symbol);
                    }
                }
                return quoteList;

            case MONTHLY:
                for (int moy = from.get(Calendar.MONTH); moy <= until.get(Calendar.MONTH); moy++) {
                    if (symbol == "APPL" && from.before(quote.getDateRecorded()) && until.after(quote.getDateRecorded())) {
                        quoteList.add(quote);
                    } else {
                        throw new MissingResourceException("Record not found", "BasicStockService", symbol);
                    }
                }
                return quoteList;

            case ANNUALLY:
                for (int year = from.get(Calendar.YEAR); year <= until.get(Calendar.YEAR); year++) {
                    if (symbol == "APPL" && from.before(quote.getDateRecorded()) && until.after(quote.getDateRecorded())) {
                        quoteList.add(quote);
                    } else {
                        throw new MissingResourceException("Record not found", "BasicStockService", symbol);
                    }
                }
                return quoteList;
        }
        return null;


    }
}
