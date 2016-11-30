package com.sample.externalserviceclient.config;

import com.google.inject.AbstractModule;

import com.sample.externalserviceclient.IExternalServiceClient;
import com.sample.externalserviceclient.internal.ExternalServiceClient;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

public class ExternalServiceClientModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IExternalServiceClient.class).to(ExternalServiceClient.class);
  }
}
