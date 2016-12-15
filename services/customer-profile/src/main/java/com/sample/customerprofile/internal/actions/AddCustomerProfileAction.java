package com.sample.customerprofile.internal.actions;

import com.google.inject.Inject;
import com.sample.common.Action;
import com.sample.customerprofile.dao.CustomerDAO;
import com.sample.customerprofile.model.Customer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by mohan on 30/11/16.
 */

@Slf4j
public class AddCustomerProfileAction implements Action<Long> {

    private Customer customer = null;

    private final CustomerDAO customerDAO;

    @Inject
    public AddCustomerProfileAction(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Long invoke() {

        log.info("Inside AddCustomerProfileAction, with customer {}", customer);

        return customerDAO.create(customer);
    }


    public AddCustomerProfileAction withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
}
