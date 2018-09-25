package stockservice;

import java.util.MissingResourceException;

/**
 * A factory to that returns the correct concrete class implementation of the 
 * StockService interface
 * 
 * @author Christopher Stafford
 */
class StockServiceFactory {
    /**
     * 
     * @return Correct concrete class for interface StockService
     */
    public static StockService getStockService() {
        return new BasicStockService();
    }
    
}
