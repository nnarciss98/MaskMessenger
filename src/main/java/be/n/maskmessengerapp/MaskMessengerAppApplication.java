package be.n.maskmessengerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("be.n.maskmessengerapp.model.repository")
public class MaskMessengerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaskMessengerAppApplication.class, args);

    }



}
