package spring.customer.dao;

import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by SBTJavastudent on 20.10.2016.
 */

@Repository
public class CustomerJdbcDao implements CustomerDao{

    @Override
    public String getNameById(Long id) {
        return "JDBC";
    }
}
