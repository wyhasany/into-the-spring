package tech.viacomcbs.intothespring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Import({MagicAutoConfigurationImportSelector.class, MagicImportRegistrar.class})
public class IntoTheSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            new Class<?>[]{IntoTheSpringApplication.class},
            args);
    }

    @RestController
    @Slf4j
    public static class SimpleController {

        public SimpleController() {
            System.out.println("Annotated bean created");
        }

        @GetMapping("/hello")
        public String hello() {
            return "Hello WJUG!!!";
        }

    }
}
