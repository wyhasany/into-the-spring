package tech.viacomcbs.intothespring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

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
            System.out.println("1st phase annotated bean init");
        }

        @PostConstruct
        void init() {
            System.out.println("2nd phase annotated bean init");
        }

        @EventListener
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.println("3rd phase annotated bean init");
        }

        @GetMapping("/hello")
        public String hello() {
            return "Hello WJUG!!!";
        }

    }
}
