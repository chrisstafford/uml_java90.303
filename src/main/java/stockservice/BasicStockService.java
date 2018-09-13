package stockservice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.MissingResourceException;

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
        StockQuote quote = new StockQuote(new Date(), new BigDecimal("342.1"), "APPL");
        
        if (symbol == "APPL") {
            return quote;
        } else {
            throw new MissingResourceException("Stock symbol not found", "BasicStockService", symbol);
    
        }
    }
}
