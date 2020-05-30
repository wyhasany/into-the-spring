package tech.viacomcbs.intothespring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            if (beanClass.getInterfaces().length > 0) {
                return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (bean1, method, args) -> profile(bean, method, args));
            } else {
                return Enhancer.create(beanClass, (org.springframework.cglib.proxy.InvocationHandler) (bean1, method, args) -> profile(bean, method, args));
            }
        }
        return bean;
    }

    private Object profile(Object bean, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("Profiling Start");
        long start = System.nanoTime();
        Object returnVal = method.invoke(bean, args);
        long end = System.nanoTime();
        System.out.println("Profiling End " + (end - start) + " ns");
        return returnVal;
    }
}
