package tech.viacomcbs.intothespring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MortyConfiguration {

    @Bean
    static MortyBeanFactoryPostProcessor mortyBeanFactoryPostProcessor() {
        return new MortyBeanFactoryPostProcessor();
    }
}
