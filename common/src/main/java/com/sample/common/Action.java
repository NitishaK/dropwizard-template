package com.sample.common;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

/**
 * @param <T>
 */
public interface Action<T> {

  T invoke();
}
