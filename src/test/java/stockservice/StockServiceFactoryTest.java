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
