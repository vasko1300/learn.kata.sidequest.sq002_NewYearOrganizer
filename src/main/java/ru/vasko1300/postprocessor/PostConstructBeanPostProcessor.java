package ru.vasko1300.postprocessor;

import lombok.SneakyThrows;
import ru.vasko1300.annotation.PostConstruct;

import java.lang.reflect.Method;

public class PostConstructBeanPostProcessor implements BeanPostProcessor {

    @Override
    @SneakyThrows
    public void process(Object bean) {
        for (Method method : bean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(bean);
            }
        }
    }
}
