package spring.customer.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by SBTJavastudent on 20.10.2016.
 */

@Repository
public interface CustomerDao {
    String getNameById(Long id);
}
