package com.sample.customerprofile.internal;

import com.codahale.metrics.annotation.Timed;
import com.sample.customerprofile.internal.actions.AddCustomerProfileAction;
import com.sample.customerprofile.internal.actions.DeleteCustomerProfileAction;
import com.sample.customerprofile.model.Customer;
import com.google.inject.Inject;
import com.google.inject.Provider;

import com.sample.customerprofile.internal.actions.GetCustomerProfileAction;
import com.sample.customerprofile.internal.actions.GetAllCustomerProfileAction;

import javax.ws.rs.*;
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

    Provider<GetCustomerProfileAction> getCustomerProfileActionProvider;
    Provider<GetAllCustomerProfileAction> getAllCustomerProfileActionProvider;
    Provider<AddCustomerProfileAction> addCustomerProfileAction;
    Provider<DeleteCustomerProfileAction> deleteCustomerProfileAction;

    @Inject
    public CustomerProfileResource(Provider<GetCustomerProfileAction> getCustomerProfileActionProvider,
                                   Provider<GetAllCustomerProfileAction> getAllCustomerProfileActionProvider,
                                   Provider<AddCustomerProfileAction> addCustomerProfileAction,
                                   Provider<DeleteCustomerProfileAction> deleteCustomerProfileAction) {
        this.getCustomerProfileActionProvider = getCustomerProfileActionProvider;
        this.getAllCustomerProfileActionProvider = getAllCustomerProfileActionProvider;
        this.addCustomerProfileAction = addCustomerProfileAction;
        this.deleteCustomerProfileAction = deleteCustomerProfileAction;
    }

    @GET
    @Path("/{id}")
    @Timed
    @Transactional
    public Customer getCustomerProfile(@PathParam("id") Long id) {
        return getCustomerProfileActionProvider.get().withCustomerId(id).invoke();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    @Transactional
    public Long addCustomerProfile(Customer customer) {
        return addCustomerProfileAction.get().withCustomer(customer).invoke();
    }

    @DELETE
    @Path("/{id}")
    @Timed
    @Transactional
    public void deleteCustomerProfile(@PathParam("id") Long id) {
        deleteCustomerProfileAction.get().withCustomerId(id).invoke();
    }

    @GET
    @Path("/")
    @Timed
    @Transactional
    public List<Customer> getAllCustomerProfile() {
        return getAllCustomerProfileActionProvider.get().invoke();
    }
}
