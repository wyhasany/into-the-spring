package tech.viacomcbs.intothespring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class FunctionalBeanConfiguration implements ApplicationContextInitializer<GenericApplicationContext> {

    static class BeanFoo {}

    static class BeanBar {
        private final BeanFoo beanFoo;

        public BeanBar(BeanFoo beanFoo) {
            this.beanFoo = beanFoo;
        }
    }

    public BeanFoo foo() {
        return new BeanFoo();
    }

    public BeanBar bar(BeanFoo foo) {
        return new BeanBar(foo);
    }


    @Override
    public void initialize(GenericApplicationContext context) {
        context.registerBean(FunctionalBeanConfiguration.class);
        context.registerBean(BeanFoo.class,
            () -> context.getBean(FunctionalBeanConfiguration.class).foo()
        );
        context.registerBean(BeanBar.class,
            () -> context.getBean(FunctionalBeanConfiguration.class)
                    .bar(context.getBean(BeanFoo.class))
        );

        // context.registerBean(BeanFoo.class);
        // context.registerBean(BeanBar.class,
        //     () -> new BeanBar(context.getBean(BeanFoo.class)));
    }
}
