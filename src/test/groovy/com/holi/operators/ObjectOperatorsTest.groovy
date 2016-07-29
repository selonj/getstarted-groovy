package com.holi.operators

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-7-30.
 */
class ObjectOperatorsTest {
  @Test void 'safe navigation ?. used to avoid a NullPointerException'() {
    String name = null;

    shouldFail(NullPointerException) {
      name.toLowerCase();
    };

    assert name?.toLowerCase() == null;
  }

  @Test void 'access field directly by .@field'() {
    def string = 'foo';

    assert string.@value == (['f', 'o', 'o'] as char[]);
  }

  @Test void 'The method pointer operator (.&) call be used to store a reference to a method in a variable'() {
    def string = 'Foo';
    def lowerCase = string.&toLowerCase;

    assert lowerCase() == string.toLowerCase();
  }
}
