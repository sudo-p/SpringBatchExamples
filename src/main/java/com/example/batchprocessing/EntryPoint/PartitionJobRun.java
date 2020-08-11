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
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@SpringBootApplication
//@ComponentScan({"com.example.batchprocessing", "com.example.batchprocessing.Domain"})
//@EnableJpaRepositories("com.example.batchprocessing.*")
//@EntityScan("com.example.batchprocessing.*")
//public class PartitionJobRun implements CommandLineRunner {
//
//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    @Qualifier("partitionJob")
//    Job partitionJob;
//
//    public static void main(String[] args) {
//        SpringApplication.run(PartitionJobRun.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        JobParameters params = new JobParametersBuilder()
//                .addString("JobID", String.valueOf(System.currentTimeMillis()))
//                .toJobParameters();
//        jobLauncher.run(partitionJob, params);
//
//    }
//
////    @RequestMapping("/runPartitionJob")
////    public String runPartitionJob(String... args) throws Exception {
////
////        JobParameters params = new JobParametersBuilder()
////                .addString("JobID", String.valueOf(System.currentTimeMillis()))
////                .toJobParameters();
////        jobLauncher.run(partitionJob, params);
////
////        return p"job started";
////
////    }
//}
//
