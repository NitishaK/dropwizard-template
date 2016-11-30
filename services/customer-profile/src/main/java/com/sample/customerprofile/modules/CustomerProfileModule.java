package com.sample.customerprofile.modules;

import com.sample.customerprofile.config.AppConfig;
import com.sample.customerprofile.dao.CustomerDAO;
import com.sample.customerprofile.internal.CustomerProfileResource;
import com.sample.externalserviceclient.config.ExternalServiceClientConfiguration;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

public class CustomerProfileModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CustomerDAO.class).in(Singleton.class);
        bind(CustomerProfileResource.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    ExternalServiceClientConfiguration providesExternalServiceClientConfiguration(final Provider<AppConfig> appConfigProvider) {
        return appConfigProvider.get().getExternalServiceClientConfiguration();
    }
}
