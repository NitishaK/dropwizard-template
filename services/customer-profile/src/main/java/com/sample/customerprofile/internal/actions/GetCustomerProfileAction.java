package com.sample.customerprofile.internal.actions;

import com.sample.common.Action;


import com.sample.customerprofile.dao.CustomerDAO;
import com.sample.customerprofile.model.Customer;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

@Slf4j
public class GetCustomerProfileAction implements Action<Customer> {


    private Long customerId;

    private final CustomerDAO customerDAO;

    @Inject
    public GetCustomerProfileAction(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer invoke() {

//        log.info("Inside GetCustomerProfileAction, with customer id - {}", customerId);

        Customer customer = customerDAO.findById(customerId);

        return customer;
    }

    @Override
    public List<Customer> invokeAll() {
        return null;
    }

    public GetCustomerProfileAction withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }
}
