package com.sample.common.utils;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;

/**
 * Created by nitisha.khandelwal on 16/05/16.
 */

public class JPAInitializer {

    @Inject
    public JPAInitializer(final PersistService service) {
        service.start();
    }
}
