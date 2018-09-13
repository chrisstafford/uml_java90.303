/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockservice;

import java.util.MissingResourceException;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author chris
 */
public class StockServiceFactoryTest {
    private StockService service;
    private String serviceName;
    
    @Before
    public void setup() {
        serviceName = "Basic";
    }
    
    @Test
    public void testGetStockServiceBasic() {
        StockService service = new BasicStockService();
        
        assertTrue("The BasicStockService was returned", StockServiceFactory.getStockService(serviceName) instanceof BasicStockService); 
    }
    
    @Test (expected = MissingResourceException.class)
    public void testGetStockServiceOther() {
        StockServiceFactory.getStockService("Other");
    }
    
    
    
}
