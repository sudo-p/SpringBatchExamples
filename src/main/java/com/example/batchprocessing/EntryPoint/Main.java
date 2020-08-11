package com.example.batchprocessing.EntryPoint;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.batchprocessing")

public class Main implements CommandLineRunner {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("skippableExceptionDuringReadSampleJob")
    Job skippableExceptionDuringReadSampleJob;

    @Autowired
    @Qualifier("skippableExceptionDuringProcessSampleJob")
    Job skippableExceptionDuringProcessSampleJob;

    @Autowired
    @Qualifier("skippableExceptionDuringWriteSampleJob")
    Job skippableExceptionDuringWriteSampleJob;

    @Autowired
    @Qualifier("taskletSampleJob")
    Job taskletSampleJob;

    @Autowired
    @Qualifier("restartSampleJob")
    Job restartSampleJob;

    @Autowired
    @Qualifier("conditionalFlowSampleJob")
    Job conditionalFlowSampleJob;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        JobParameters params = new JobParametersBuilder()
                //.addString("JobID", String.valueOf(System.currentTimeMillis()))
                .addString("JobID", "PASS")
                .toJobParameters();

        jobLauncher.run(skippableExceptionDuringReadSampleJob, params);
//        jobLauncher.run(skippableExceptionDuringProcessSampleJob, params);
//        jobLauncher.run(skippableExceptionDuringWriteSampleJob, params);
//        jobLauncher.run(taskletSampleJob, params);
//        jobLauncher.run(restartSampleJob, params);
//        jobLauncher.run(conditionalFlowSampleJob, params);
    }
}
