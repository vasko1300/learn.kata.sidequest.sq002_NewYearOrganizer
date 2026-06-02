package ru.vasko1300.service.impl;

import ru.vasko1300.model.Gift;
import ru.vasko1300.service.PaymentSystem;

public class CashPaymentSystem implements PaymentSystem {
    @Override
    public void pay(Gift gift) {
        System.out.printf("Pay %.2f for %s by CASH%n", gift.getPrice(), gift.getName());
    }
}
