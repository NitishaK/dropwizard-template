package com.sample.customerprofile.internal;

import com.codahale.metrics.annotation.Timed;
import com.sample.customerprofile.model.Customer;
import com.google.inject.Inject;
import com.google.inject.Provider;

import com.sample.customerprofile.internal.actions.GetCustomerProfileAction;
import com.sample.customerprofile.internal.actions.GetAllCustomerProfileAction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.persist.Transactional;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

@Slf4j
@Path("/v1/customers")
@Produces(MediaType.APPLICATION_JSON)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerProfileResource {

//    Provider<GetCustomerProfileAction> getCustomerProfileActionProvider;
    Provider<GetAllCustomerProfileAction> getAllCustomerProfileActionProvider;

    /*@Inject
    public CustomerProfileResource(Provider<GetCustomerProfileAction> getCustomerProfileActionProvider) {
        this.getCustomerProfileActionProvider = getCustomerProfileActionProvider;
    }*/

    @Inject
    public CustomerProfileResource(Provider<GetAllCustomerProfileAction> getAllCustomerProfileActionProvider) {
        this.getAllCustomerProfileActionProvider = getAllCustomerProfileActionProvider;
    }

    /*@GET
    @Path("/{id}")
    @Timed
    @Transactional
    public Customer getCustomerProfile(@PathParam("id") Long id) {
        return getCustomerProfileActionProvider.get().withCustomerId(id).invoke();
    }*/

    @GET
    @Path("/")
    @Timed
    @Transactional
    public List<Customer> getAllCustomerProfile() {
        return getAllCustomerProfileActionProvider.get().invokeAll();
    }
}
