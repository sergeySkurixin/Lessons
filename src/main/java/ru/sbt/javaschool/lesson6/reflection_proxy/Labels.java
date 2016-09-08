package ru.sbt.javaschool.lesson6.reflection_proxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by скурихин on 27.08.2016.
 */
@interface Language {
    String lang();

    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Key {
    Language[] value();
}

public interface Labels {
    @Key ({
            @Language(lang = "ru", value = "Логин"),
            @Language(lang = "en", value = "Login")
    })
    String username();

    @Key ({
            @Language(lang = "ru", value = "Где мои деньги, $0?"),
            @Language(lang = "en", value = "Where is my money, $0?")
    })
    String getMyMoneyBro(String bro);
}
