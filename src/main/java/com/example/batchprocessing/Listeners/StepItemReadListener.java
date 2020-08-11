package com.example.batchprocessing.Listeners;

import org.springframework.batch.core.ItemReadListener;

public class StepItemReadListener implements ItemReadListener<Integer> {

    @Override
    public void beforeRead() {
        System.out.println("ItemReadListener - beforeRead");
    }

    @Override
    public void afterRead(Integer item) {
        System.out.println("ItemReadListener - afterRead");
    }

    @Override
    public void onReadError(Exception ex) {
        System.out.println("ItemReadListener - onReadError");
    }
}
