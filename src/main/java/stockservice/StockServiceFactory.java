/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockservice;

import java.util.MissingResourceException;

/**
 *
 * @author chris
 */
class StockServiceFactory {
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
