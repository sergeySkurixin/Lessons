package spring.customer.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by SBTJavastudent on 20.10.2016.
 */
@Component
public class Customer {

    @Value("#{'test'.toUpperCase()}")
    private String name;

    @Value("#{priceService.getSpecialPrice()")
    private BigDecimal amount;

    @Value("#{priceService.getSpecialPrice()>0 ? true:false}")
    private Boolean isSpecialPrice;

    @Override
    public String toString() {
        return "Customer [name=" + name + ", amount=" + amount;
    }
}
