package com.sample.customerprofile.config;

import com.sample.externalserviceclient.config.ExternalServiceClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by nitisha.khandelwal on 05/05/16.
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Getter
public class AppConfig extends Configuration {

    @Valid
    @NotNull
    private ExternalServiceClientConfiguration externalServiceClientConfiguration = new ExternalServiceClientConfiguration();
}
