package ru.vasko1300.factory;

import lombok.SneakyThrows;
import ru.vasko1300.config.Configuration;
import ru.vasko1300.config.JavaConfiguration;
import ru.vasko1300.configurator.BeanConfigurator;
import ru.vasko1300.configurator.JavaBeanConfigurator;

public class BeanFactory {

    private static final BeanFactory BEAN_FACTORY = new BeanFactory();
    private final Configuration configuration;
    private final BeanConfigurator beanConfigurator;

    private BeanFactory() {
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(
                configuration.getPackageToScan(),
                configuration.getInterfaceToImplementation()
        );
    }

    public static BeanFactory getInstance() {
        return BEAN_FACTORY;
    }

    @SneakyThrows
    public <T> T getBean(Class<T> clazz) {
        Class<? extends T> implementationClass = clazz;
        if (clazz.isInterface()) {
            implementationClass = beanConfigurator.getImplementationClass(implementationClass);
        }
        return implementationClass.getDeclaredConstructor().newInstance();
    }
}
