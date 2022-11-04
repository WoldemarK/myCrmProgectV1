package com.example.mycrmprogectv1.config;

import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.contact.Contact;
import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.tasc.Action;
import com.example.mycrmprogectv1.model.tasc.Status;
import com.example.mycrmprogectv1.model.tasc.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public Employee employee(){
        return new Employee(company());
    }
    @Bean
    public Company company (){
        return new Company(contact());
    }
    @Bean
   public Contact contact(){
        return new Contact(company());
    }
    @Bean
    public Task task(){
        return new Task(action(), status(),company() );
    }
    @Bean
    public Action action(){
        return new Action();
    }
    @Bean
    public Status status(){
        return new Status();
    }
}
