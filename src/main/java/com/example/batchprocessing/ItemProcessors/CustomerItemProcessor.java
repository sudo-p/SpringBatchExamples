//package com.example.batchprocessing.ItemProcessors;
//
//import com.example.batchprocessing.Domain.Customer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemProcessor;
//
//public class CustomerItemProcessor implements ItemProcessor<Customer, Customer> {
//
//	private static final Logger log = LoggerFactory.getLogger(CustomerItemProcessor.class);
//
//	@Override
//	public Customer process(final Customer customer) throws Exception {
//		final String firstName = customer.getFirstName().toUpperCase();
//		final String lastName = customer.getLastName().toUpperCase();
//
//		final Customer transformedCustomer = new Customer(firstName, lastName);
//
//		//log.info("Converting (" + customer + ") into (" + transformedCustomer + ")");
//		log.info("Converting (" + customer + ")");
//
//		return transformedCustomer;
//	}
//
//}
