package ru.vasko1300.service.impl;

import ru.vasko1300.model.Gift;
import ru.vasko1300.service.PaymentSystem;

public class CardPaymentSystem implements PaymentSystem {
    @Override
    public void pay(Gift gift) {
        System.out.printf("Pay %.2f for a %s by CARD%n", gift.getPrice(), gift.getName());
    }
}
