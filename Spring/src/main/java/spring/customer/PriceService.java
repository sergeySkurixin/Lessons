package spring.customer;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by SBTJavastudent on 20.10.2016.
 */
@Component
public class PriceService {

    public BigDecimal getSpecialPrice(){
        return new BigDecimal(100);
    }
}
