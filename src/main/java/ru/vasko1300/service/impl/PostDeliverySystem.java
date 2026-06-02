package ru.vasko1300.service.impl;

import ru.vasko1300.model.Gift;
import ru.vasko1300.model.Person;
import ru.vasko1300.service.DeliverySystem;

public class PostDeliverySystem implements DeliverySystem {
    @Override
    public void deliver(Gift gift, Person person) {
        System.out.printf("Deliver a %s to %s by POST\n", gift.getName(), person.getName());
    }
}
