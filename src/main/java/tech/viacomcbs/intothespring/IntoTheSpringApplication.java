package tech.viacomcbs.intothespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.support.GenericApplicationContext;
import tech.viacomcbs.intothespring.FunctionalBeanConfiguration.BeanBar;
import tech.viacomcbs.intothespring.FunctionalBeanConfiguration.BeanFoo;

@SpringBootApplication
public class IntoTheSpringApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(IntoTheSpringApplication.class)
            .initializers(
                (GenericApplicationContext context) -> context.registerBean(BeanFoo.class),
                (GenericApplicationContext context) -> context.registerBean(BeanBar.class,
                    () -> new BeanBar(context.getBean(BeanFoo.class)))
            )
            .run(args);
    }
}
