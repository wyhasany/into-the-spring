package tech.viacomcbs.intothespring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RickBeanPostProcessor implements BeanPostProcessor {

    public RickBeanPostProcessor() {
        System.out.println("RickBeanPostProcessor Initialized");
    }

    static boolean postProcessBefore = true;
    static boolean postProcessAfter = true;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (postProcessBefore || beanName.contains("SimpleController")) {
            System.out.println("BeanPostProcessor.postProcessBeforeInitialization: " + bean + " with name " + beanName);
            postProcessBefore = false;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (postProcessAfter || beanName.contains("SimpleController")) {
            System.out.println("BeanPostProcessor.processAfterInitialization: " + bean + " with name " + beanName);
            postProcessAfter = false;
        }
        return bean;
    }
}
