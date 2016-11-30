package com.sample.common;

/**
 * Created by nitisha.khandelwal on 06/05/16.
 */

import java.util.List;

/**
 * @param <T>
 */
public interface Action<T> {

  T invoke();
  List<T> invokeAll();
}
