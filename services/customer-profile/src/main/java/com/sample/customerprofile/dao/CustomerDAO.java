package com.sample.customerprofile.dao;

import com.sample.common.utils.GenericDAO;
import com.sample.customerprofile.model.Customer;

import java.util.Date;
import java.util.List;

/**
 * Created by nitisha.khandelwal on 13/05/16.
 */

public class CustomerDAO extends GenericDAO<Customer, Long> {

    public Customer findById(Long id) {
        return super.find(id);
    }
    public List<Customer> getAll() {
        return super.findAll();
    }
    public Long create(Customer customer) {
        Date d = customer.getCreateDateTime();
        customer.setCreateDateTime(d);
        return super.insert(customer);
    }
    public void delete(Customer customer) {
        super.delete(customer);
    }
}
