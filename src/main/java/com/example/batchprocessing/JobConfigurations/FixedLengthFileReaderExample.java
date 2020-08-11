//package com.example.batchprocessing.JobConfigurations;
//
//import com.example.batchprocessing.Repositories.Person;
//import com.example.batchprocessing.ItemProcessors.PersonItemProcessor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.mapping.FieldSetMapper;
//import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
//import org.springframework.batch.item.file.transform.Range;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;
//
//@Configuration
//@EnableBatchProcessing
//public class FixedLengthFileReaderExample {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    // tag::readerwriterprocessor[]
//    @Bean
//    public FlatFileItemReader<Person> reader() {
//        FlatFileItemReader<Person> itemReader = new FlatFileItemReader<>();
//        itemReader.setResource(new ClassPathResource("fileLengthSampleData.data"));
//        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
//        lineMapper.setLineTokenizer(fixedLengthTokenizer());
//        lineMapper.setFieldSetMapper(fieldSetMapper());
//        itemReader.setLineMapper(lineMapper);
//        return itemReader;
//
//        //itemReader.setResource(new FileSystemResource("resources/fileLengthSampleData.data"));
//    }
//
//    @Bean
//    public FixedLengthTokenizer fixedLengthTokenizer() {
//
//        FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
//
//        tokenizer.setNames("firstName", "lastName");
//        tokenizer.setColumns(new Range(1,10),
//                new Range(11,20));
//
//        return tokenizer;
//    }
//
//    @Bean
//    public FieldSetMapper fieldSetMapper() {
//        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
//        fieldSetMapper.setPrototypeBeanName("person");
//        return fieldSetMapper;
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Person person() {
//        return new Person();
//    }
//
//
//    @Bean
//    public PersonItemProcessor processor() {
//        return new PersonItemProcessor();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Person> writer(javax.sql.DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<Person>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>()) //TODO
//                .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public Job fixedLengthFileReaderExampleJob(Step step1) {
//        return jobBuilderFactory.get("fixedLengthFileReaderExampleJob")
//                .incrementer(new RunIdIncrementer())
//                .start(step1)
//                .build();
//    }
//
//    @Bean
//    public Step step1(JdbcBatchItemWriter<Person> writer) {
//        return stepBuilderFactory.get("step1")
//                .<Person, Person> chunk(1)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer)
//                .build();
//    }
//
//}
//
