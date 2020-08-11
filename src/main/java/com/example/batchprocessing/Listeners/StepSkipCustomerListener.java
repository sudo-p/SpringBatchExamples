//package com.example.batchprocessing.Listeners;
//
//import com.example.batchprocessing.Domain.Customer;
//import org.springframework.batch.core.SkipListener;
//
//public class StepSkipCustomerListener implements SkipListener<Customer,Customer> {
//
//    @Override
//    public void onSkipInRead(Throwable t) {
//        System.out.println("StepSkipListener - onSkipInRead");
//    }
//
//    @Override
//    public void onSkipInWrite(Customer customer, Throwable t) {
//
//        System.out.println("StepSkipListener - afterWrite");
//        System.out.println("skipping item: " + customer);
//        System.out.println(t.getMessage());
//        System.out.println(t.getLocalizedMessage());
//    }
//
//    @Override
//    public void onSkipInProcess(Customer customer, Throwable t) {
//        System.out.println("StepSkipListener - onWriteError");
//    }
//}
