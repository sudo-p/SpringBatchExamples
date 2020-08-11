package com.example.batchprocessing.JobConfigurations;

import java.util.Arrays;

import com.example.batchprocessing.Listeners.JobResultListener;
import com.example.batchprocessing.Listeners.StepItemReadListener;
import com.example.batchprocessing.Listeners.StepSkipListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SkippableExceptionDuringProcessSample {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<Integer> itemReaderSkipProcess() {
        return new ListItemReader<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)) {
            @Override
            public Integer read() {
                Integer item = super.read();
                System.out.println("reading item = " + item);
                return item;
            }
        };
    }

    @Bean
    public ItemProcessor<Integer, Integer> itemProcessorSkipProcess() {
        return item -> {
            if (item.equals(5)) {
                System.out.println("Throwing exception on item " + item);
                throw new IllegalArgumentException("Unable to process 5");
            }
            System.out.println("processing item = " + item);
            return item;
        };
    }

    @Bean
    public ItemWriter<Integer> itemWriterSkipProcess() {
        return items -> {
            System.out.println("About to write chunk: " + items);
            for (Integer item : items) {
                System.out.println("writing item = " + item);
            }
        };
    }

    @Bean
    public Step stepSkipProcess() {
        return this.stepBuilderFactory.get("step")
                .<Integer, Integer>chunk(3)
                .reader(itemReaderSkipProcess())
                .processor(itemProcessorSkipProcess())
                .writer(itemWriterSkipProcess())
                .faultTolerant()
                .skip(IllegalArgumentException.class)
                .skipLimit(3)
                .listener(new StepItemReadListener())
                .listener(new StepSkipListener())
                .build();
    }

    @Bean
    public Job skippableExceptionDuringProcessSampleJob() {
        return this.jobBuilderFactory.get("skippableExceptionDuringProcessSampleJob")
                .listener(new JobResultListener())
                .start(stepSkipProcess())
                .build();
    }
}
