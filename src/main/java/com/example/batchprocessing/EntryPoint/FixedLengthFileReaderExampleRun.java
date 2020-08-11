//package com.example.batchprocessing.EntryPoint;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//
//@SpringBootApplication
//@ComponentScan("com.example.batchprocessing")
//public class FixedLengthFileReaderExampleRun implements CommandLineRunner {
//
//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    @Qualifier("fixedLengthFileReaderExampleJob")
//    Job fixedLengthFileReaderExampleJob;
//
//    public static void main(String[] args)
//    {
//        SpringApplication.run(FixedLengthFileReaderExampleRun.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception
//    {
//        JobParameters params = new JobParametersBuilder()
//                .addString("JobID", String.valueOf(System.currentTimeMillis()))
//                .toJobParameters();
//        jobLauncher.run(fixedLengthFileReaderExampleJob, params);
//    }
//}
//
