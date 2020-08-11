package com.example.batchprocessing.JobConfigurations;

import com.example.batchprocessing.Tasklets.MyTaskOne;
import com.example.batchprocessing.Tasklets.MyTaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class TaskletSample {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

//    @Autowired
//    JobExecution jobExecution;

    @Bean
    public Step stepOneTasklet(){
        return stepBuilderFactory.get("stepOne")
                //.tasklet(new MyTaskOne(jobExecution.getJobParameters()))
                .tasklet(new MyTaskOne())
                .build();
    }

    @Bean
    public Step stepTwoTasklet(){
        return stepBuilderFactory.get("stepTwo")
                .tasklet(new MyTaskTwo())
                .build();
    }

    @Bean
    public Job taskletSampleJob(){
        return jobBuilderFactory.get("taskletSampleJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOneTasklet())
                .next(stepTwoTasklet())
                .build();
    }
}