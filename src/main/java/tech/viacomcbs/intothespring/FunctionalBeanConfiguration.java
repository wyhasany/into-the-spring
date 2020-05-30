package tech.viacomcbs.intothespring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class FunctionalBeanConfiguration {

    static class BeanFoo {}

    static class BeanBar {
        private final BeanFoo beanFoo;

        public BeanBar(BeanFoo beanFoo) {
            this.beanFoo = beanFoo;
        }
    }
}
