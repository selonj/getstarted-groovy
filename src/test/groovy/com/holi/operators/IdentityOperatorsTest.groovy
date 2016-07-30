package com.holi.operators

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-7-30.
 */
class IdentityOperatorsTest {
  @Test void 'use is method to compare reference equality'() {
    def string1 = new String('string');
    def string2 = new String('string');

    assert string1 == string2;
    assert string1.is(string1);
    assert !string1.is(string2);
  }

  @Test void 'identify operator is null-safe'() {
    assert null.is(null);
  }
}
