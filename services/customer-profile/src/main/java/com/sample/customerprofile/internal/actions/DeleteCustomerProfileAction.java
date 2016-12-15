package com.sample.customerprofile.internal.actions;

import com.google.inject.Inject;
import com.sample.common.Action;
import com.sample.customerprofile.dao.CustomerDAO;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by mohan on 30/11/16.
 */

@Slf4j
public class DeleteCustomerProfileAction implements Action<Object> {

    private Long customerId = null;

    private final CustomerDAO customerDAO;

    @Inject
    public DeleteCustomerProfileAction(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Void invoke() {

        log.info("Inside DeleteCustomerProfileAction, with customer id - {}", customerId);

        customerDAO.delete(customerDAO.findById(customerId));

        return null;

    }

    public DeleteCustomerProfileAction withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }
}
