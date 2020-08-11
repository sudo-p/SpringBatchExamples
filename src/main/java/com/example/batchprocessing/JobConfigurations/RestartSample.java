package com.example.batchprocessing.JobConfigurations;

import com.example.batchprocessing.ItemReaders.FilesInDirectoryItemReader;
import com.example.batchprocessing.ItemWriters.DummyItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@Configuration
@EnableBatchProcessing
public class RestartSample {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job restartSampleJob() {

        return jobBuilderFactory
                .get("restartSampleJob")
                .start(stepRestartSample())
                .build();
    }

    @Bean
    protected Step stepRestartSample() {
        return
                stepBuilderFactory
                        .get("stepRestartSample")
                        .<File, File> chunk(1)
                        .reader(readerRestartSample())
                        .writer(writerRestartSample())
                        .build();
    }

    @Bean
    protected ItemReader<File> readerRestartSample() {
        FilesInDirectoryItemReader reader = new FilesInDirectoryItemReader();
        reader.setDirectory("C:\\development\\LocalLabs\\CSS\\Flexbox-1");
        return reader;
    }

    @Bean
    protected ItemWriter<Object> writerRestartSample() {
        return new DummyItemWriter();
    }
}

