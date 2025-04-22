package me.nettee.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = "me.nettee")
@ConfigurationPropertiesScan(basePackages = "me.nettee")
public class ClientApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ClientApiApplication.class, args);
    }
}
