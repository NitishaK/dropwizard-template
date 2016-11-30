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
public class GetAllCustomerProfileAction implements Action<Customer> {

    private final CustomerDAO customerDAO;

    @Inject
    public GetAllCustomerProfileAction(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer invoke() {
        return null;
    }

    @Override
    public List<Customer> invokeAll() {
        List<Customer> customers = customerDAO.getAll();
        return customers;
    }
}
