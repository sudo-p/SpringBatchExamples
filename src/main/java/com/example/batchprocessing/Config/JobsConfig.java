package com.example.batchprocessing.Config;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobsConfig {

//    @Autowired
//    JobLoader jobLoader;

    @Autowired
    JobRegistry jobRegistry;

    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor() {
        JobRegistryBeanPostProcessor postProcessor = new JobRegistryBeanPostProcessor();
        postProcessor.setJobRegistry(jobRegistry);
        return postProcessor;
    }
//
//    @Autowired
//    ApplicationContextFactory[] applicationContextFactories;

//    @Bean
//    public SimpleJobOperator jobOperator(final JobLauncher jobLauncher, final JobRepository jobRepository,
//                                   final JobRegistry jobRegistry, final JobExplorer jobExplorer) {
//        final SimpleJobOperator jobOperator = new SimpleJobOperator();
//        jobOperator.setJobLauncher(jobLauncher);
//        jobOperator.setJobRepository(jobRepository);
//        jobOperator.setJobRegistry(jobRegistry);
//        jobOperator.setJobExplorer(jobExplorer);
//        return jobOperator;
//    }

//    @Bean
//    public JobExplorer jobExplorer(final DataSource dataSource) throws Exception {
//        final JobExplorerFactoryBean bean = new JobExplorerFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setTablePrefix("BATCH_");
//        bean.setJdbcOperations(new JdbcTemplate(dataSource));
//        bean.afterPropertiesSet();
//        return bean.getObject();
//    }

//    @Bean
//    public AutomaticJobRegistrar registrar() {
//
//        AutomaticJobRegistrar registrar = new AutomaticJobRegistrar();
//        registrar.setJobLoader(jobLoader);
//        registrar.setApplicationContextFactories(applicationContextFactories);
//        registrar.afterPropertiesSet();
//        return registrar;
//
//    }

}
