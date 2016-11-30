package com.sample.common.test;

import com.google.inject.Provider;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

public class MockitoExt {

  public static <T> Provider<T> mockProvider(final T mock) {
    return new Provider<T>() {
      @Override
      public T get() {
        return mock;
      }
    };
  }

}