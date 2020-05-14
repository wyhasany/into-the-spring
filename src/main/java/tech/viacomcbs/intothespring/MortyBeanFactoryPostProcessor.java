package tech.viacomcbs.intothespring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MortyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MortyBeanFactoryPostProcessor() {
        System.out.println("MortyBeanFactoryPostProcessor constructed");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MortyBeanFactoryPostProcessor.postProcessBeanFactory with beanFactory" + beanFactory);
    }
}
