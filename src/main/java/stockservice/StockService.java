/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockservice;

/**
 *
 * @author chris
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
