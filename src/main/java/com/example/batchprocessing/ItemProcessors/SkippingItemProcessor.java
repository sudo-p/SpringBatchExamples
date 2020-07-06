//package com.example.batchprocessing.ItemProcessors;
//
//import com.example.batchprocessing.CustomExceptions.MissingUsernameException;
//import com.example.batchprocessing.CustomExceptions.NegativeAmountException;
//import com.example.batchprocessing.Domain.Transaction;
//import org.springframework.batch.item.ItemProcessor;
//
//public class SkippingItemProcessor implements ItemProcessor<Transaction, Transaction> {
//
//    @Override
//    public Transaction process(Transaction transaction) {
//
//        System.out.println("SkippingItemProcessor: " + transaction);
//
//        if (transaction.getUsername() == null || transaction.getUsername().isEmpty()) {
//            throw new MissingUsernameException();
//        }
//
//        double txAmount = transaction.getAmount();
//        if (txAmount < 0) {
//            throw new NegativeAmountException(txAmount);
//        }
//
//        return transaction;
//    }
//}
