package ru.vasko1300.config;

import ru.vasko1300.service.PaymentSystem;
import ru.vasko1300.service.impl.CashPaymentSystem;

import java.util.Map;

public class JavaConfiguration implements Configuration {
    @Override
    public String getPackageToScan() {
        return "ru.vasko1300";
    }

    @Override
    public Map<Class, Class> getInterfaceToImplementation() {
        return Map.of(PaymentSystem.class, CashPaymentSystem.class);
    }
}
