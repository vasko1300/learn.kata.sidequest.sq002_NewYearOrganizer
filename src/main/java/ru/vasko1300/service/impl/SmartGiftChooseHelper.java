package ru.vasko1300.service.impl;

import ru.vasko1300.annotation.Inject;
import ru.vasko1300.model.Gift;
import ru.vasko1300.model.Person;
import ru.vasko1300.service.GiftChooseHelper;
import ru.vasko1300.service.Recommendator;

public class SmartGiftChooseHelper implements GiftChooseHelper {
    @Inject
    private Recommendator recommendator;

    @Override
    public Gift choose(Person person) {
        recommendator.recommend();
        return new Gift("Smart watches", 10000.0);
    }
}
