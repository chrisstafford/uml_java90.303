package stockservice;

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
    
}
