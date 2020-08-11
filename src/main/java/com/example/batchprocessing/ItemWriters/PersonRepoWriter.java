//package com.example.batchprocessing.ItemWriters;
//
//import com.example.batchprocessing.Repositories.Person;
//import com.example.batchprocessing.Repositories.PersonRepository;
//import org.springframework.batch.item.data.RepositoryItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class PersonRepoWriter extends RepositoryItemWriter<Person> {
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Override
//    public void write(List<? extends Person> people) throws Exception {
//        for (Person person : people){
//            System.out.println("----------------------------");
//            System.out.println(person);
//            System.out.println("personRepository: " + personRepository);
//            System.out.println("----------------------------");
//            personRepository.save(person);
//        }
//        //super.write(people);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        setRepository(personRepository);
//        setMethodName("save");
//    }
//}
