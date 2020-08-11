//package com.example.batchprocessing.JobConfigurations;
//
//import com.example.batchprocessing.Domain.Customer;
//import com.example.batchprocessing.ItemProcessors.CustomerItemProcessor;
//import com.example.batchprocessing.ItemWriters.CustomerRepoWriter;
//import com.example.batchprocessing.Listeners.JobCompletionNotificationListener;
//import com.example.batchprocessing.Listeners.StepSkipCustomerListener;
//import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
//import org.hibernate.exception.ConstraintViolationException;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.dao.DuplicateKeyException;
//
//import javax.persistence.PersistenceException;
//
//@Configuration
//@EnableBatchProcessing
//public class ImportFromCSVtoTableSampleWithSkipDuplicates {
//
//	@Autowired
//	public JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	public StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	public FlatFileItemReader<Customer> reader() {
//		return new FlatFileItemReaderBuilder<Customer>()
//			.name("customerItemReader")
//			.resource(new ClassPathResource("sample-data.csv"))
//			.delimited()
//			.names(new String[]{"firstName", "lastName"})
//			.fieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {{       //TODO
//				setTargetType(Customer.class);
//			}})
//			.build();
//	}
//
//	@Bean
//	public CustomerItemProcessor processor() {
//		return new CustomerItemProcessor();
//	}
//
////	@Bean
////	public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
////		return new JdbcBatchItemWriterBuilder<Person>()
////			.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>()) //TODO
////			.sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
////			.dataSource(dataSource)
////			.build();
////	}
//
//	@Bean
//	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
//	return jobBuilderFactory.get("importUserJob")
//		.incrementer(new RunIdIncrementer())
//		.listener(listener)
//		.flow(step1)
//		.end()
//		.build();
//	}
//
////    @Bean
////    public Step step1(JdbcBatchItemWriter<Person> writer) {
//	@Bean
//		public Step step1(CustomerRepoWriter customerRepoWriter) {
//        return stepBuilderFactory.get("step1")
//                .<Customer, Customer>chunk(2)
//                .reader(reader())
//                .processor(processor())
//                //.writer(writer)
//				.writer(customerRepoWriter)
//                .faultTolerant()
//                .skip(DuplicateKeyException.class)
//				.skip(JdbcSQLIntegrityConstraintViolationException.class)
//				.skip(ConstraintViolationException.class)
//				.skip(PersistenceException.class)
//                .skipLimit(10)
//                .listener(new StepSkipCustomerListener())
//                .build();
//	}
//
//}
