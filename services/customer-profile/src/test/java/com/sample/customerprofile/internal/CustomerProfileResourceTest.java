package com.sample.customerprofile.internal;

import com.sample.common.MockitoExt;
import com.sample.customerprofile.internal.actions.AddCustomerProfileAction;
import com.sample.customerprofile.internal.actions.DeleteCustomerProfileAction;
import com.sample.customerprofile.internal.actions.GetAllCustomerProfileAction;
import com.sample.customerprofile.internal.actions.GetCustomerProfileAction;
import com.sample.customerprofile.model.Customer;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import io.dropwizard.testing.junit.ResourceTestRule;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

public class CustomerProfileResourceTest {

    public static final String RESOURCE_LOCATION = "/v1/customers/";

    @Mock
    private static GetCustomerProfileAction getCustomerProfileAction = Mockito.mock(GetCustomerProfileAction.class);
    @Mock
    private static GetAllCustomerProfileAction getAllCustomerProfileAction = Mockito.mock(GetAllCustomerProfileAction.class);
    @Mock
    private static AddCustomerProfileAction addCustomerProfileAction = Mockito.mock(AddCustomerProfileAction.class);
    @Mock
    private static DeleteCustomerProfileAction deleteCustomerProfileAction = Mockito.mock(DeleteCustomerProfileAction.class);

    @ClassRule
    public final static ResourceTestRule resources = ResourceTestRule.builder().addResource(
            new CustomerProfileResource(
                    MockitoExt.mockProvider(getCustomerProfileAction),
                    MockitoExt.mockProvider(getAllCustomerProfileAction),
                    MockitoExt.mockProvider(addCustomerProfileAction),
                    MockitoExt.mockProvider(deleteCustomerProfileAction)
            )).build();

    @Before
    public void setUpResources() {
        reset(getCustomerProfileAction);
    }

    @Test
    public void testGetCustomerProfile() throws IOException {

        Long customerId = 320L;
        String location = RESOURCE_LOCATION + customerId;

        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setCustomerName("Happy Singh");

        when(getCustomerProfileAction.withCustomerId(customerId)).thenReturn(getCustomerProfileAction);
        when(getCustomerProfileAction.invoke()).thenReturn(customer);

        Response response = resources.client().target(location).request(MediaType.APPLICATION_JSON_TYPE).get();

        Customer customerResponse = response.readEntity(Customer.class);

        assertEquals(customerResponse.getCustomerName(), "Happy Singh");

    }

}
