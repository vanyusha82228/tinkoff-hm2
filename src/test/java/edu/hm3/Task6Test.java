package edu.hm3;

import edu.hm3.task6.Stock;
import edu.hm3.task6.StockMarket;
import edu.hm3.task6.StockMarketDo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    public void testMostValuableStock(){
        StockMarket stockMarketDo = new StockMarketDo();
        Stock appleStock = new Stock("Apple", 150.0);
        Stock googleStock = new Stock("Google", 250.0);
        Stock microsoftStock = new Stock("Microsoft", 180.0);

        stockMarketDo.add(appleStock);
        stockMarketDo.add(googleStock);
        stockMarketDo.add(microsoftStock);

        Stock mostValuableStock = stockMarketDo.mostValuableStock();
        assertEquals("Google",mostValuableStock.getName());
        assertEquals(250.0,mostValuableStock.getPrice());
    }
}
