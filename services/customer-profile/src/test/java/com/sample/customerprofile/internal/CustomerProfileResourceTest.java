/*
package com.sample.customerprofile.internal;

import com.sample.common.MockitoExt;
import com.sample.customerprofile.internal.actions.GetAllCustomerProfileAction;
import com.sample.customerprofile.internal.actions.GetCustomerProfileAction;
import com.sample.customerprofile.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import io.dropwizard.jackson.Jackson;
import io.dropwizard.testing.junit.ResourceTestRule;

*/
/**
 * Created by nitisha.khandelwal on 06/05/16.
 *//*


public class CustomerProfileResourceTest {

    public static final String RESOURCE_LOCATION = "/v1" +
            "/customers/";

    private ObjectMapper objectMapper = Jackson.newObjectMapper();

    @Mock
    private static GetAllCustomerProfileAction getCustomerProfileAction = Mockito.mock(GetAllCustomerProfileAction.class);

    @ClassRule
    public final static ResourceTestRule resources = ResourceTestRule.builder().addResource(
            new CustomerProfileResource(MockitoExt.mockProvider(getCustomerProfileAction))).build();


    @Before
    public void setUpResources() {
        reset(getCustomerProfileAction);
    }

    @Test
    public void testGetCustomerProfile() throws IOException {

        Long customerId = 320L;
        String location = RESOURCE_LOCATION + customerId;

        List<Customer> customers = new ArrayList<>(1);

        Customer customer = new Customer();
        customer.setId(320L);
        customer.setCustomerName("Happy Singh");

        when(getCustomerProfileAction).thenReturn(getCustomerProfileAction);
        when(getCustomerProfileAction.invokeAll()).thenReturn(customers);

        Response response = resources.client().target(location).request(MediaType.APPLICATION_JSON_TYPE).get();

        Customer customerResponse = response.readEntity(Customer.class);

        assertEquals(customerResponse.getCustomerName(), "Happy Singh");

    }

}
*/
