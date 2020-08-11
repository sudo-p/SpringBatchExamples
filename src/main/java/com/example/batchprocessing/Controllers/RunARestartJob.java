package com.example.batchprocessing.Controllers;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.ListableJobLocator;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RunARestartJob {

    @Autowired
    private ListableJobLocator jobRegistry;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    JobExplorer jobExplorer;

    @Autowired
    SimpleJobOperator jobOperator;

    @Autowired
    @Qualifier("restartSampleJob")
    Job restartSampleJob;

    @GetMapping
    @RequestMapping("/restartSampleJob")
//    public String runARestartJob(@PathVariable long executionId) throws Exception {
    public String runARestartJob() throws Exception {

//        JobParameters params = new JobParametersBuilder()
//                .addString("JobID", String.valueOf(System.currentTimeMillis()))
//                .toJobParameters();

//          jobLauncher.run(restartSampleJob,params);

        System.out.println("---------------------------------------");
        System.out.println("I AM HERE-I AM HERE-I AM HERE-I AM HERE");
        System.out.println("---------------------------------------");
        jobOperator.restart(1);

        return "Job restarted";
    }

    @GetMapping
    @RequestMapping("/jobInfo")
    public String getJobInfo() throws Exception {

        System.out.println(jobOperator.getJobInstances("restartSampleJob",0,10));
        System.out.println(jobOperator.getJobNames());
        System.out.println(jobOperator.getExecutions(1));

        JobExecution jobExecution = jobExplorer.getJobExecution((long) 1);
        System.out.println("jobExecution : " + jobExecution);

        String jobName = jobExecution.getJobInstance().getJobName();
        System.out.println("jobName: " + jobName);

        /*
        this jobRegistry object will not have any job unless jobs are registerdd with it.
        JobRegistryBeanPostProcessor bean is required to resgiter all jobs as they are created.
         */

        Job job = jobRegistry.getJob(jobName);
        System.out.println("job: " + job);

        return "info printed";
    }

}