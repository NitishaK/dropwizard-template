package com.sample.common.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.client.Client;
import java.time.Clock;

/**
 * Created by nitisha.khandelwal on 05/05/16.
 */

public class CommonModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(Client.class).to(JerseyClient.class);
    }

    @Provides
    Clock providesClock() {
        return Clock.systemDefaultZone();
    }

    @Provides
    ObjectMapper objectMapper(Environment environment) {
        return environment.getObjectMapper();
    }

}
