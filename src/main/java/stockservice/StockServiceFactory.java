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
     * @param serviceName as <CODE>String</CODE>
     * @return Correct concrete class for interface StockService 
     */
    public static StockService getStockService(String serviceName) {
        if (serviceName == null) {
            throw new NullPointerException();
        }
        else if ( serviceName == "Basic") {
            return new BasicStockService();
        }
        throw new MissingResourceException("Service not found", "StockServiceFactory", serviceName);
    }
    
}
