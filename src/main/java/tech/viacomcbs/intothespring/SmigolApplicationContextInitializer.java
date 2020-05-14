package tech.viacomcbs.intothespring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class SmigolApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public SmigolApplicationContextInitializer() {
        System.out.println("SmigolApplicationContextInitializer created");
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("SmigolApplicationContextInitializer.initialize()");
    }
}
