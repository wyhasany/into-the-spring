package tech.viacomcbs.intothespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntoTheSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            new Class<?>[]{IntoTheSpringApplication.class},
            args);
    }
}
