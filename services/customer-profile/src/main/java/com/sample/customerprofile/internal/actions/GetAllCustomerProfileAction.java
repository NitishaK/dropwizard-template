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
public class GetAllCustomerProfileAction implements Action<List<Customer>> {

    private final CustomerDAO customerDAO;

    @Inject
    public GetAllCustomerProfileAction(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> invoke() {

        log.info("Inside GetAllCustomerProfileAction");

        List<Customer> customers = customerDAO.getAll();

        return customers;
    }

}
