package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class UnaryOperatorsTest {
  def one = 1;
  def two = 2;

  @Test void 'positive +'() {
    assert +1 == 1;
  }

  @Test void 'negative -'() {
    assert -(-1) == 1;
  }

  @Test void 'next ++'() {
    assert one++ == 1;
    assert ++two == 3;
  }

  @Test void 'previous --'() {
    assert one-- == 1;
    assert --two == 1;
  }
}
