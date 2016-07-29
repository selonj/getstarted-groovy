package com.holi.syntax

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class MapsTest {
  @Test void 'define map by [:]'() {
    assert [:].getClass() == LinkedHashMap;
  }

  @Test void 'access map value by key using property notation'() {
    def map = [foo: 'bar'];

    assert map.foo == 'bar';
  }

  @Test void 'access map value by key using subscript notation'() {
    def map = [foo: 'bar'];

    assert map['foo'] == 'bar';
  }

  @Test void 'return null value when key does not exists'() {
    def empty = [:];

    assert empty.anything == null;
  }

  @Test void 'pass variable values as keys in your map definitions, you must surround the variable or expression with parentheses'() {
    def key = 'foo';
    def map = [(key): 'bar'];

    assert map.foo == 'bar';
  }

  @Test void 'using other types as key'() {
    def map = [1: 'one', (2): 'two', (true): 'ok'];

    assert map[1] == 'one';
    assert map[2] == 'two';
    assert map[true] == 'ok';
  }
}
