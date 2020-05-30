package tech.viacomcbs.intothespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class ProfileEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            environment.addActiveProfile("dev");
        } else {
            environment.addActiveProfile("prod");
        }
    }
}
