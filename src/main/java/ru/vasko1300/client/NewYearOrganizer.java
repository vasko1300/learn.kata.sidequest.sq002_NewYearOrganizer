package ru.vasko1300.client;

import ru.vasko1300.annotation.Inject;
import ru.vasko1300.factory.BeanFactory;
import ru.vasko1300.model.Person;
import ru.vasko1300.service.GiftPresenter;

public class NewYearOrganizer {

    @Inject private GiftPresenter giftPresenter;

    public void prepareToCelebration() {
        Person friend = new Person("Jacob");
        giftPresenter.present(friend);
    }
}
