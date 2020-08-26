package com.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner sampleData(EmployeeRepository repository) {
        return (args) -> {
            repository.save(new Employee("tester", "Testing"));
            repository.save(new Employee("developer", "Development"));
            repository.save(new Employee("splunkmaster", "Agile"));
        };
    }
}
