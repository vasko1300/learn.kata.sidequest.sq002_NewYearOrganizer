package ru.vasko1300.service;

import ru.vasko1300.factory.BeanFactory;
import ru.vasko1300.model.Gift;
import ru.vasko1300.model.Person;
import ru.vasko1300.service.impl.CardPaymentSystem;
import ru.vasko1300.service.impl.PostDeliverySystem;
import ru.vasko1300.service.impl.SmartGiftChooseHelper;

public class GiftPresenter {

    private GiftChooseHelper giftChooseHelper = BeanFactory.getInstance().getBean(GiftChooseHelper.class);
    private PaymentSystem paymentSystem = BeanFactory.getInstance().getBean(PaymentSystem.class);
    private DeliverySystem deliverySystem = BeanFactory.getInstance().getBean(DeliverySystem.class);

    public void present(Person person) {
        Gift gift = giftChooseHelper.choose(person);
        System.out.printf("Gift has been choosen: %s\n", gift.getName());
        paymentSystem.pay(gift);
        deliverySystem.deliver(gift, person);
    }
}
