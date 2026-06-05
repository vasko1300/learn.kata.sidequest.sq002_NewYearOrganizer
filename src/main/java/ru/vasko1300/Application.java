package ru.vasko1300;

import ru.vasko1300.client.NewYearOrganizer;
import ru.vasko1300.context.ApplicationContext;
import ru.vasko1300.factory.BeanFactory;

public class Application {

    public ApplicationContext run() {
        ApplicationContext applicationContext = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(applicationContext);
        applicationContext.setBeanFactory(beanFactory);
        return applicationContext;
    }

    static void main(String[] args) {
        Application application = new Application();
        ApplicationContext applicationContext = application.run();

        NewYearOrganizer organizer = applicationContext.getBean(NewYearOrganizer.class);
        organizer.prepareToCelebration();
    }
}
