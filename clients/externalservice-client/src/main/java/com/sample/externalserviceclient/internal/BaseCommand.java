package com.sample.externalserviceclient.internal;

import com.google.inject.Inject;

import com.sample.externalserviceclient.config.ExternalServiceClientConfiguration;

import javax.ws.rs.client.Client;

import lombok.Data;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

@Data
public class BaseCommand {

  protected final Client client;
  protected final ExternalServiceClientConfiguration configuration;

  @Inject
  public BaseCommand(Client client, ExternalServiceClientConfiguration configuration) {
    this.client = client;
    this.configuration = configuration;
  }
}
