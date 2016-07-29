package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class ArithmeticOperatorsTest {
  @Test void 'plus +'() {
    assert 1 + 2 == 3;
  }

  @Test void 'minus -'() {
    assert 3 - 1 == 2;
  }

  @Test void 'multiply *'() {
    assert 3 * 2 == 6;
  }

  @Test void 'div /'() {
    assert 6 / 2 == 3;
  }

  @Test void 'mod %'() {
    assert 5 % 3 == 2;
  }

  @Test void 'power **'() {
    assert 2**3 == 2 * 2 * 2;
  }
}
