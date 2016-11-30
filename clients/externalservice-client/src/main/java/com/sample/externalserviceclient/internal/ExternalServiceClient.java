package com.sample.externalserviceclient.internal;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import com.sample.externalserviceclient.IExternalServiceClient;

import javax.ws.rs.core.Response;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

@Singleton
public class ExternalServiceClient implements IExternalServiceClient {

  private final BaseCommand baseCommand;

  @Inject
  public ExternalServiceClient(BaseCommand baseCommand) {
    this.baseCommand = baseCommand;
  }

  @Override
  public Response getResponse(String id) {
    GetAPICommand command = new GetAPICommand(baseCommand, id);
    return command.execute();
  }

  @Override
  public Response postRequest(String request) {
    return null;
  }
}
