package stockservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Main class for Stock quote application
 */
public class StockQuoteApplication {

    public static void main(String args[]) {
        /**
         * Get String from argument 0
         */
        String symbol = args[0];
        /**
         * Create Date format for from and until dates
         */
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        /**
         * Create from and until  date variables as Calendar
         */
        Calendar from = Calendar.getInstance();
        Calendar until = Calendar.getInstance();

        /**
         * Set from date as Calendar
         */
        try {
            from.setTime(sdf.parse(args[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**
         * Set until date from Calendar
         */
        try {
            from.setTime((sdf.parse(args[2])));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        StockService service = StockServiceFactory.getStockService();

        List<StockQuote> output = service.getQuote(symbol, from, until);

        /**
         * Print out each stock quote from requested list
         */
        for (StockQuote quote : output) {
            System.out.println(quote.toString());
        }
    }

}
