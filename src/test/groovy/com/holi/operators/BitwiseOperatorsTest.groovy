package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class BitwiseOperatorsTest {
  @Test void 'and &'() {
    assert (0b1 & 0b1) == 0b1;
    assert (0b1 & 0b10) == 0b0;
  }

  @Test void 'or |'() {
    assert (0b1 | 0b1) == 0b1;
    assert (0b1 | 0b10) == 0b11;
  }

  @Test void 'xor ^'() {
    assert (0b1 ^ 0b1) == 0b0;
    assert (0b1 ^ 0b10) == 0b11;
  }

  @Test void 'bitwiseNegate ~'() {
    def mask = 0b1111;

    assert ((~0b0001) & mask) == 0b1110;
  }
}
