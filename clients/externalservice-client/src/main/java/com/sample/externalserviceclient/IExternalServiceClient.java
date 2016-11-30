package com.sample.externalserviceclient;

import javax.ws.rs.core.Response;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

public interface IExternalServiceClient {

  Response getResponse(String id);

  Response postRequest(String request);

}
