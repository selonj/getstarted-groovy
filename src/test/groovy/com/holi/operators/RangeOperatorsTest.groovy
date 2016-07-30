package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class RangeOperatorsTest {
  @Test void 'create ranges of objects by ..'() {
    assert 1..2 instanceof Range;
  }

  @Test void 'create ranges include upper bound'() {
    assert (1..3) == [1, 2, 3];
  }

  @Test void 'create ranges exclusive upper bound'() {
    assert (1..<3) == [1, 2];
  }
}
