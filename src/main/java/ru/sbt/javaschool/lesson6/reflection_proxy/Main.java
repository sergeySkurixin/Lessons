package ru.sbt.javaschool.lesson6.reflection_proxy;

import com.sun.java.browser.net.ProxyService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by скурихин on 27.08.2016.
 */

class LabelsIsInvokationHandler implements InvocationHandler {
    private String language;

    public LabelsIsInvokationHandler(String language) {
        this.language = language;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {

        Key key = method.getAnnotation(Key.class);
        Language[] languages = key.value();
        for (Language methodLanguage : languages) {
            if (methodLanguage.lang().equals(language)) {
                String MessageFormat = methodLanguage.value();
                if(args!=null){
                    return MessageFormat.replaceAll("\\$"+0, String.valueOf(args[0]));
                }
                else
                    return MessageFormat;
            }
        }
        return "";
    }


}

public class Main {
    public static void main(String[] args) throws Exception {
        Labels ruLabels = getLabels("ru");
        Labels enLabels = getLabels("en");

        System.out.println(ruLabels.username());
        System.out.println(enLabels.username());
        System.out.println(ruLabels.getMyMoneyBro("Чувак"));
        System.out.println(enLabels.getMyMoneyBro("Dude"));
    }

    private static Labels getLabels(String language) {
        return (Labels) Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class<?>[]{Labels.class},
                new LabelsIsInvokationHandler(language)
        );
    }
}
