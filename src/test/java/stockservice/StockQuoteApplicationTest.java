package stockservice;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class StockQuoteApplicationTest {

    private String symbol;
    private Calendar from;
    private Calendar until;

    @Before
    public void setup() {
        symbol="APPL";
        from = Calendar.getInstance();
        until = Calendar.getInstance();
        from.add(Calendar.DATE, -10);
        until.add(Calendar.DATE, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testMainNegative(){
        StockQuoteApplication.main(null);
    }

}
