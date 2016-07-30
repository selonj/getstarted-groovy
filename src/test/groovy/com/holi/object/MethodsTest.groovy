package com.holi.object

import org.junit.Test

/**
 * Created by selonj on 16-7-31.
 */
class MethodsTest {
  def sizeOfNamedParameters(Map parameters) {
    return parameters.size();
  }

  @Test void 'method with named parameters must be define parameters as map'() {
    assert sizeOfNamedParameters(foo: 'bar', key: 'value') == 2;
  }

  def times(int number, int times = 2) {
    return number * times;
  }

  @Test void 'method with default value'() {
    assert times(3) == 6;
    assert times(3, 3) == 9;
  }

  def count(int ... items) {
    return items?.size();
  }

  @Test void 'methods with a variable number of arguments'() {
    assert count(0, 1, 2) == 3;
  }

  int sum(int[] items) {
    return items.sum();
  }

  @Test void 'any method with an array as last parameter allows T[] as a alternative notation to T…​'() {
    assert sum(1, 2, 3) == 6;
  }

  @Test void 'returns null if a method with varargs is called with null as the vararg parameter'() {
    assert count(null) == null;
  }
}
