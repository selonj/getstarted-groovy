package com.holi.traits

import org.junit.Test

/**
 * Created by selonj handle 16-7-31.
 */
class RuntimeImplementationTest {
  trait Action {
    def execute() {
      return 'success';
    }
  }

  trait Handler {
    def handle() {
      return true;
    }
  }

  @Test void 'coercing an object to a trait by \'as\' operator, the result of the operation is not the same instance and not a instance of original class'() {
    def original = 'foo';

    def decorated = original as Action;

    assert !decorated.is(original);
    assert decorated instanceof Action;
    assert !(decorated instanceof String);
    assert decorated.substring(0, 1) == 'f'; //but can call methods of original
  }

  @Test void 'implementing multiple traits at once'() {
    def original = new Object();

    def decorated = original.withTraits(Action, Handler);

    assert decorated.execute() == 'success';
    assert decorated.handle();
  }
}
