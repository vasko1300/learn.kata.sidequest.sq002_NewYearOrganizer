package ru.vasko1300.factory;

import lombok.Getter;
import lombok.SneakyThrows;
import ru.vasko1300.annotation.Inject;
import ru.vasko1300.config.Configuration;
import ru.vasko1300.config.JavaConfiguration;
import ru.vasko1300.configurator.BeanConfigurator;
import ru.vasko1300.configurator.JavaBeanConfigurator;
import ru.vasko1300.context.ApplicationContext;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BeanFactory {

    private final Configuration configuration;
    @Getter
    private final BeanConfigurator beanConfigurator;
    private final ApplicationContext applicationContext;

    public BeanFactory(ApplicationContext applicationContext) {
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(
                configuration.getPackageToScan(),
                configuration.getInterfaceToImplementation()
        );
        this.applicationContext = applicationContext;
    }

    @SneakyThrows
    public <T> T getBean(Class<T> clazz) {
        Class<? extends T> implementationClass = clazz;
        if (clazz.isInterface()) {
            implementationClass = beanConfigurator.getImplementationClass(implementationClass);
        }
        T bean = implementationClass.getDeclaredConstructor().newInstance();
        for (Field field : Arrays.stream(implementationClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Inject.class)).collect(Collectors.toList())) {
            field.setAccessible(true);
            field.set(bean, applicationContext.getBean(field.getType()));
        }


        return bean;
    }
}
