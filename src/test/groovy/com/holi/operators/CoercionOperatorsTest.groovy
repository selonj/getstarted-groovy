package com.holi.operators

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-7-30.
 */
class CoercionOperatorsTest {
  @Test void 'converts object from one type to another without them being compatible for assignment'() {
    def string = '123';

    shouldFail(ClassCastException) {
      def castFailed = (Number) string;
    }

    def number = string as Integer;

    assert number == 123;
  }

  @Test void 'custom conversion rules may be implemented by the asType method'() {
    def name = new Name(name: 'foo');

    assert (name as Name).is(name);
    assert name as String == 'foo';
  }

  class Name {
    def name;

    def asType(Class type) {
      if (type == Name) return this;
      if (type == String) return name;
      throw new ClassCastException();
    }
  }
}
