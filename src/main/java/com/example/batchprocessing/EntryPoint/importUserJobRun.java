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
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.util.StopWatch;
//
//@SpringBootApplication
//@ComponentScan({"com.example.batchprocessing","com.example.batchprocessing.Domain"})
//@EnableJpaRepositories("com.example.batchprocessing.*")
//@EntityScan("com.example.batchprocessing.*")
//public class importUserJobRun implements CommandLineRunner {
//
//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    @Qualifier("importUserJob")
//    Job importUserJob;
//
//    public static void main(String[] args)
//    {
//        SpringApplication.run(importUserJobRun.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception
//    {
//        StopWatch watch = new StopWatch();
//        watch.start();
//
//        JobParameters params = new JobParametersBuilder()
//                .addString("JobID", String.valueOf(System.currentTimeMillis()))
//                .toJobParameters();
//        jobLauncher.run(importUserJob, params);
//
//        watch.stop();
//        System.out.println("Time Elapsed: " + watch.getLastTaskTimeMillis());
//        watch.prettyPrint();
//    }
//}
//
