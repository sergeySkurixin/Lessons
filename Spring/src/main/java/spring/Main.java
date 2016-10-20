package spring;

/**
 * Created by SBTJavastudent on 20.10.2016.
 */

import org.springframework.context.support.*;
import spring.customer.CustomerService;
import spring.customer.model.Customer;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xsl");

//        HelloWorld hello_world = (HelloWorld) context.getBean("helloWorld");
//        hello_world.printHello();

//        CustomerService customerService = context.getBean(CustomerService.class);
//        System.out.println(customerService.getNameById(1L));

        //CustomerService customerService = context.getBean(CustomerService.class);
//        customerService.setName("first object");
//        System.out.println(customerService.getName());

        Customer customer = context.getBean(Customer.class);
        System.out.println(customer);

        context.close();
    }
}
