package com.example.batchprocessing.JobConfigurations;

import com.example.batchprocessing.Tasklets.MyTaskOne;
import com.example.batchprocessing.Tasklets.MyTaskThree;
import com.example.batchprocessing.Tasklets.MyTaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ConditionalFlowSample {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

//    @Autowired
//    JobExecution jobExecution;

    @Bean
    public Step stepOneConditionalFlow(){
        return stepBuilderFactory.get("stepOne")
                //.tasklet(new MyTaskOne(jobExecution.getJobParameters()))
                .tasklet(new MyTaskOne())
                .build();
    }

    @Bean
    public Step stepTwoConditionalFlow(){
        return stepBuilderFactory.get("stepTwo")
                .tasklet(new MyTaskTwo())
                .build();
    }

    @Bean
    public Step stepThreeConditionalFlow(){
        return stepBuilderFactory.get("stepThree")
                .tasklet(new MyTaskThree())
                .build();
    }

    @Bean
    public Job conditionalFlowSampleJob(){
        return jobBuilderFactory.get("conditionalFlowSampleJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOneConditionalFlow())
                .on("*").to(stepThreeConditionalFlow())
                .from(stepOneConditionalFlow()).on("FAILED").to(stepTwoConditionalFlow())
                .build()
                .build();
    }
}