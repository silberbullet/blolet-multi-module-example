package me.nettee.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
       "config","api","service",
        "mapper","entity","repository","handler"
})
@EnableJpaRepositories(basePackages = "repository") // 리포지토리 패키지 지정
public class ClientApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ClientApiApplication.class, args);
    }
    
}
