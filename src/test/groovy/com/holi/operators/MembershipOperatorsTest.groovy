package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class MembershipOperatorsTest {
  @Test void 'the membership operator (in) is equivalent to calling the isCase method'() {
    assert 'foo' in ['foo', 'bar']; //equivalent to calling list.contains('foo') or list.isCase('foo')
    assert !('other' in ['foo', 'bar']);
  }
}
