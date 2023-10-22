package edu.hm3.task6;

import java.util.PriorityQueue;

public class StockMarketDo implements StockMarket {

    private PriorityQueue<Stock> queue = new PriorityQueue<>((s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice()));

    @Override
    public void add(Stock stock) {
        queue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        queue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return queue.peek();
    }

    @Override public String toString() {
        return "StockMarketDo{"
            + "queue=" + queue
            + '}';
    }
}
