package com.sample.customerprofile;

import com.sample.common.modules.CommonModule;
import com.sample.common.modules.PersistenceModule;
import com.sample.common.swagger.SwaggerBundle;
import com.sample.customerprofile.config.AppConfig;
import com.sample.customerprofile.modules.CustomerProfileModule;
import com.sample.externalserviceclient.config.ExternalServiceClientModule;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.inject.Stage;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.filter.LoggingFilter;

import java.util.logging.Logger;

/**
 * Created by nitisha.khandelwal on 05/05/16.
 */

public class App extends Application<AppConfig> {

    private GuiceBundle<AppConfig> guiceBundle;
    private JpaPersistModule jpaModule;

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "Dropwizard Sample";
    }

    @Override
    public void initialize(Bootstrap bootstrap) {

        GuiceBundle.Builder<AppConfig> guiceBundleBuilder = GuiceBundle.newBuilder();

        jpaModule = new JpaPersistModule("dropwizard-template");

        guiceBundle = guiceBundleBuilder
                .setConfigClass(AppConfig.class)
                .addModule(jpaModule)
                .addModule(new CommonModule())
                .addModule(new CustomerProfileModule())
                .addModule(new ExternalServiceClientModule())
                .addModule(new PersistenceModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .build(Stage.DEVELOPMENT);

        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(new SwaggerBundle());

    }

    @Override
    public void run(AppConfig configuration, Environment environment) throws Exception {

        PersistService persistService = guiceBundle.getInjector().getInstance(PersistService.class);
        persistService.start();

        environment.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        environment.jersey().register(new LoggingFilter(Logger.getLogger(LoggingFilter.class.getName()), true));
    }
}
