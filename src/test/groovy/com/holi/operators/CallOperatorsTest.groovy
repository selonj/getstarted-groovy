package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class CallOperatorsTest {
  class Triple {
    def call(int x) {
      return 3 * x;
    }
  }

  @Test void 'the call operator () is used to call a method named call implicitly'() {
    def triple = new Triple();

    assert triple(3) == triple.call(3);
  }
}
