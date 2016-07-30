package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class SpaceshipOperatorsTest {
  @Test void 'the spaceship operator (<=>) delegates to the compareTo method'() {
    assert 1 <=> 2 == -1;
    assert 1 <=> 1 == 0;
    assert 2 <=> 1 == 1;
  }
}
