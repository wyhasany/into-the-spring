package tech.viacomcbs.intothespring;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeansConfiguration {

    static {
        System.out.println("MyApplicationsBeansConfiguration loaded");
    }

}
