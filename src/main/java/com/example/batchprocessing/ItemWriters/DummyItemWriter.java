package com.example.batchprocessing.ItemWriters;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import java.util.List;

public class DummyItemWriter implements ItemWriter<Object> {

    private Object someObject;

    @Override
    public void write(List<? extends Object> item) throws Exception {
        System.out.println("Dummy Writing");
    }

    @BeforeStep
    public void retrieveInterstepData(StepExecution stepExecution) {
        JobExecution jobExecution = stepExecution.getJobExecution();
        ExecutionContext jobContext = jobExecution.getExecutionContext();
        this.someObject = jobContext.get("someKey");
        System.out.println("someObject: " + someObject);
    }

}
