package com.example.batchprocessing.Tasklets;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class MyTaskOne implements Tasklet {

//    private JobParameters jobParameters;
//
//    public MyTaskOne(JobParameters jobParameters) {
//        this.jobParameters = jobParameters;
//    }

    @Value("#{jobParameters['JobID']}")
    private String param;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("MyTaskOne start..");

        // ... your code
//        System.out.println("fetching job parm for key JobID");
//        String param = jobParameters.getString("JobID");
        System.out.println("printing parm received:" + param);
//        assert param != null;
//        if (param.equals("FAIL")) {
//            System.out.println("Forcing MyTaskOne to fail");
//            throw new Exception("Forced Failure");
//        }

        System.out.println("MyTaskOne done..");
        return RepeatStatus.FINISHED;
    }
}
