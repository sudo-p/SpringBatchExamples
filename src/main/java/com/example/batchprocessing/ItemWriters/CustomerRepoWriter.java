//package com.example.batchprocessing.ItemWriters;
//
//import com.example.batchprocessing.Domain.Customer;
//import com.example.batchprocessing.Repositories.CustomerRepository;
//import org.springframework.batch.item.data.RepositoryItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Component
//public class CustomerRepoWriter extends RepositoryItemWriter<Customer> {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private EntityManager em;
//
//    @Override
//    public void write(List<? extends Customer> customers) throws Exception {
//        for (Customer customer : customers) {
////            System.out.println("----------------------------");
//            System.out.println("writing customer :" + customer);
////            System.out.println("customerRepository: " + customerRepository);
////            System.out.println("----------------------------");
//              customerRepository.save(customer);
//        }
//        //super.write(customers);
//        em.flush();
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        setRepository(customerRepository);
//        setMethodName("save");
//    }
//}
