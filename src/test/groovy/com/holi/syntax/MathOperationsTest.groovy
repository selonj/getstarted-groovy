package com.holi.syntax

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class MathOperationsTest {
  @Test void 'power'() {
    assert 2**4 == 2 * 2 * 2 * 2;
  }

  @Test void 'power will adapt number type automatically with its capacity'() {
    assert (10**24).class == BigInteger;
  }
}
