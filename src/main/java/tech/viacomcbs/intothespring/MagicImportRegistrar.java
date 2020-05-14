package tech.viacomcbs.intothespring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MagicImportRegistrar implements ImportBeanDefinitionRegistrar {

    public MagicImportRegistrar() {
        System.out.println("MagicImportRegistrar created");
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        System.out.println("MagicImportRegistrar.registerBeanDefinitions() Importing auto configuration");
    }
}
