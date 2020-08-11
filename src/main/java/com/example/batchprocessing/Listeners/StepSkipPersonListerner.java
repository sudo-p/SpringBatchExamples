//package com.example.batchprocessing.Listeners;
//
//import com.example.batchprocessing.Repositories.Person;
//import org.springframework.batch.core.SkipListener;
//
//public class StepSkipPersonListerner implements SkipListener<Person,Person> {
//
//    @Override
//    public void onSkipInRead(Throwable t) {
//        System.out.println("StepSkipListener - onSkipInRead");
//    }
//
//    @Override
//    public void onSkipInWrite(Person person, Throwable t) {
//
//        System.out.println("StepSkipListener - afterWrite");
//        System.out.println("skipping item: " + person);
//    }
//
//    @Override
//    public void onSkipInProcess(Person person, Throwable t) {
//        System.out.println("StepSkipListener - onWriteError");
//    }
//}
