package spring.customer;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.customer.dao.CustomerDao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by SBTJavastudent on 20.10.2016.
 */

@Service
public class CustomerService {
    @Autowired @Qualifier("customerJdbcDao")
//    @Inject
//    @Named("customerJdbcDao")
    private CustomerDao customerDao;
    @Value("Serj")
    private String name;

    public CustomerService() {
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameById(Long id){
        return customerDao.getNameById(id);
    }

    public CustomerService(CustomerDao customerDao, String name) {
        this.customerDao = customerDao;
        this.name = name;
    }

    @PostConstruct
    public void init(){
        System.out.println("start");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }
}
