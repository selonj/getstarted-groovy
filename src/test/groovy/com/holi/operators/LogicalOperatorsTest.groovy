package com.holi.operators

import org.junit.Test

import static org.junit.Assert.fail

/**
 * Created by selonj on 16-7-30.
 */
class LogicalOperatorsTest {
  @Test void 'not !'() {
    assert !false;
  }

  @Test void 'and &&'() {
    assert true && true;
  }

  @Test void 'or ||'() {
    assert false || true;
  }

  @Test void 'The logical "not" has a higher priority than others'() {
    assert (!false && false) == false;
  }

  @Test void 'The logical "and" has a higher priority than the logical "or".'() {
    assert true || true && false
  }

  @Test void 'short-circuiting'() {
    assert (false && fail()) == false;
    assert (true || fail()) == true;
  }
}
