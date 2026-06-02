package ru.vasko1300.client;

import ru.vasko1300.factory.BeanFactory;
import ru.vasko1300.model.Person;
import ru.vasko1300.service.GiftPresenter;

public class NewYearOrganizer {

    private GiftPresenter giftPresenter = BeanFactory.getInstance().getBean(GiftPresenter.class);

    public void prepareToCelebration() {
        Person friend = new Person("Jacob");
        giftPresenter.present(friend);
    }
}
