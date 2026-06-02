package ru.vasko1300.service;

import ru.vasko1300.model.Gift;
import ru.vasko1300.model.Person;

public interface DeliverySystem {
    void deliver(Gift gift, Person person);
}
