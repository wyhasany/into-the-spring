package tech.viacomcbs.intothespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IntoTheSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(
            new Class<?>[]{IntoTheSpringApplication.class},
            args);
        MyBean bean = context.getBean(MyBean.class);
        bean.repeat();
    }
}
