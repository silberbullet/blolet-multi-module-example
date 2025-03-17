package me.nettee.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "me.nettee")
public class ClientApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ClientApiApplication.class, args);
    }
}
