package com.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.math.BigDecimal;
import java.util.Calendar;

@SpringBootApplication
public class StartBookApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartBookApplication.class, args);
    }

    // run this only on profile 'demo', avoid run this in test
    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(BookRepository repository, EmployeeRepository empRepository,StudentRepository studRepository,
    		ParentRepository parentRepository, InstallmentRepository installmentRepository) {
        return args -> {
            repository.save(new Book("A G the Bodhisattva Way of Life", "Santideva", new BigDecimal("15.41")));
            repository.save(new Book("The Life-Changing Magic of Tidying Up", "Marie Kondo", new BigDecimal("9.69")));
            repository.save(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", new BigDecimal("47.99")));
            
            empRepository.save(new Employee(101l, "Prashant", "Bari", 102,
        			"987654321"));
            empRepository.save(new Employee(101l, "Kokila", "Bari", 102,
        			"987654321"));
            empRepository.save(new Employee(101l, "Rahul", "Kulkarni", 102,
        			"987654321"));

            studRepository.save(new Student("demo", "PRN1010", "Prashant", "Ramesh", "Bari", "13, Ronak Colony, Jalgaon", "13, Ronak Colony, Jalgaon", "prashant.bari.3@gmail.com", "9404594334", "NA", "MBA", "BE, MBA", null, 400l, 200l, 200l));
            studRepository.save(new Student("demo", "PRN1010", "Prashant", "Ramesh", "Bari", "13, Ronak Colony, Jalgaon", "13, Ronak Colony, Jalgaon", "prashant.bari.3@gmail.com", "9404594334", "NA", "MBA", "BE, MBA", null, 400l, 200l, 200l));
            studRepository.save(new Student("demo", "PRN1010", "Prashant", "Ramesh", "Bari", "13, Ronak Colony, Jalgaon", "13, Ronak Colony, Jalgaon", "prashant.bari.3@gmail.com", "9404594334", "NA", "MBA", "BE, MBA", null, 400l, 200l, 200l));

            parentRepository.save(new Parent(101l, "demo", "PR101", "Ramesh", "Puna", "Bari", "13, Ronak Colony, Jalgaon", "13, Ronak Colony, Jalgaon", "prashant.bari.3@gmail.com", "9404594334", "NA", "MBA", "BE, MBA", null));

            installmentRepository.save(new Installment(new BigDecimal("1000"), Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Paid"));
        };
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
       return new WebMvcConfigurerAdapter() {
          @Override
          public void addCorsMappings(CorsRegistry registry) {
             registry.addMapping("/students").allowedOrigins("*");
          }
       };
    }
}