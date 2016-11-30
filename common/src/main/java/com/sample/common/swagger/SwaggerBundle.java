package com.sample.common.swagger;

import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * Created by nitisha.khandelwal on 09/05/16.
 */


/**
 * DropWizard bundle for swagger
 * <p>
 * Will add the swagger assets to the http path /apidocs
 */

public class SwaggerBundle implements ConfiguredBundle<Configuration> {

    private AssetsBundle assetsBundle;

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        assetsBundle.run(environment);
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
        assetsBundle = new AssetsBundle("/apidocs", "/apidocs", "index.html", "/apidocs");
    }

}
