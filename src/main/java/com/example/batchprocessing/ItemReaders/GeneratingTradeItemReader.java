//package com.example.batchprocessing.ItemReaders;
//
//import com.example.batchprocessing.Domain.Trade;
//
//import org.springframework.batch.item.ItemReader;
//import org.springframework.lang.Nullable;
//
//import java.math.BigDecimal;
//
//public class GeneratingTradeItemReader implements ItemReader<Trade> {
//
//    private int limit = 1;
//
//    private int counter = 0;
//
//    @Nullable
//    @Override
//    public Trade read() throws Exception {
//        if (counter < limit) {
//            counter++;
//            System.out.println("Reading new Trade");
//            return new Trade(
//                    "isin" + counter,
//                    counter,
//                    new BigDecimal(counter),
//                    "customer" + counter);
//        }
//        return null;
//    }
//
//    /**
//     * @param limit number of items that will be generated
//     * (null returned on consecutive calls).
//     */
//    public void setLimit(int limit) {
//        this.limit = limit;
//    }
//
//    public int getCounter() {
//        return counter;
//    }
//
//    public int getLimit() {
//        return limit;
//    }
//
//    public void resetCounter()
//    {
//        this.counter = 0;
//    }
//}