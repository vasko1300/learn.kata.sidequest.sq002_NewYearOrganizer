package ru.vasko1300.service;

import ru.vasko1300.annotation.Inject;
import ru.vasko1300.annotation.PostConstruct;
import ru.vasko1300.model.Gift;
import ru.vasko1300.model.Person;

public class GiftPresenter {

    @Inject private GiftChooseHelper giftChooseHelper;
    @Inject private PaymentSystem paymentSystem;
    @Inject private DeliverySystem deliverySystem;

    @PostConstruct public void postConstruct() {
        System.out.println("GiftPresenter has been initialized!");
    }

    public void present(Person person) {
        Gift gift = giftChooseHelper.choose(person);
        System.out.printf("Gift has been choosen: %s\n", gift.getName());
        paymentSystem.pay(gift);
        deliverySystem.deliver(gift, person);
    }
}
