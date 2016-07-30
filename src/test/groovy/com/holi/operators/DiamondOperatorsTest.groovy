package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class DiamondOperatorsTest {
  @Test void 'the diamond operator (<>) is used to indicate that generic types should be inferred from the declaration'() {
    List<String> strings = ['foo', 'bar'];

    assert strings == ['foo', 'bar'];
  }
}
