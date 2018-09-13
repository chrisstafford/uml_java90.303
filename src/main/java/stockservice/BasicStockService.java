/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockservice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.MissingResourceException;

/**
 *
 * @author chris
 */
public class BasicStockService implements StockService {
    
    public StockQuote getQuote(String symbol) {
        StockQuote quote = new StockQuote(new Date(), new BigDecimal("342.1"), "APPL");
        
        if (symbol == "APPL") {
            return quote;
        } else {
            throw new MissingResourceException("Stock symbol not found", "BasicStockService", symbol);
    
        }
    }
}
