package com.sample.common.modules;

import com.sample.common.utils.JPAInitializer;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Created by nitisha.khandelwal on 16/05/16.
 */

public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(JPAInitializer.class).in(Singleton.class);
    }
}
