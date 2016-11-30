package com.sample.common.utils;

import java.io.Serializable;

/**
 * Created by nitisha.khandelwal on 16/05/16.
 */

public abstract class AbstractEntity<P> implements Serializable {

    public abstract P getId();
}