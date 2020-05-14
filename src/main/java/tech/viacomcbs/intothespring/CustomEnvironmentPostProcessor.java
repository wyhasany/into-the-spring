package tech.viacomcbs.intothespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {

    public CustomEnvironmentPostProcessor() {
        System.out.println("CustomEnvironmentPostProcessor Initialized");
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("postProcessEnvironment");
    }
}
