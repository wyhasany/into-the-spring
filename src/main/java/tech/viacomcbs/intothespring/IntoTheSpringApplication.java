package tech.viacomcbs.intothespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class IntoTheSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            new Class<?>[]{IntoTheSpringApplication.class},
            args);
    }

    @Profile("prod")
    @Component
    static class Prod {
        public Prod() {
            System.out.println("prod");
        }
    }

    @Profile("dev")
    @Component
    static class Dev {
        public Dev() {
            System.out.println("dev");
        }
    }

}
