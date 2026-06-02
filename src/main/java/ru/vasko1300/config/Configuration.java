package ru.vasko1300.config;

import java.util.Map;

public interface Configuration {

    String getPackageToScan();

    Map<Class, Class> getInterfaceToImplementation();
}
