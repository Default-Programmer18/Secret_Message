package com.secret.msg.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.secret.msg.entities.UserData;
import com.secret.msg.repository.UserRepo;

@Configuration
public class MongoConfig {

	@Bean
    CommandLineRunner initDb(UserRepo repository) {
        // create an instance of your @Document annotated class
        UserData myDocument = new UserData("Sanghita","sanghita1818@gmail.com","");
        
        myDocument = repository.insert(myDocument);
        repository.delete(myDocument);
        return (args) -> {
        }; 
    }
}
