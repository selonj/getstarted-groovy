package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class RelationalOperatorsTest {
  @Test void 'equals =='() {
    assert !new String('foo').is(new String('foo'));
    assert new String('foo').equals(new String('foo'));

    assert new String('foo') == new String('foo');
  }

  @Test void 'different !='() {
    assert !(new String('foo') != new String('foo'));
  }

  @Test void 'less than <'() {
    assert 3 < 4;
    assert !(3 < 3);
    assert !(3 < 2);
  }

  @Test void 'less than or equal <='() {
    assert 3 <= 4;
    assert 3 <= 3;
    assert !(3 <= 2);
  }

  @Test void 'greater than >'() {
    assert 3 > 2;
    assert !(3 > 3);
    assert !(3 > 4);
  }

  @Test void 'greater than or equal >='() {
    assert 3 >= 2;
    assert 3 >= 3;
    assert !(3 >= 4);
  }
}
