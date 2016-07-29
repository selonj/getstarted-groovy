package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class ConditionalOperatorsTest {
  @Test void 'not ! '() {
    assert !false;
    assert !'';
    assert ![];
  }

  @Test void 'ternary a?b:c'() {
    assert (true ? 'foo' : 'bar') == 'foo';
    assert (false ? 'foo' : 'bar') == 'bar';
  }

  @Test void 'elvis'() {
    assert (null ?: 'default') == 'default';
    assert ('some' ?: 'default') == 'some';
    assert (false ?: 'default') == 'default';
    assert ([] ?: 'default') == 'default';
    assert (true ?: 'default') == true;
  }
}
