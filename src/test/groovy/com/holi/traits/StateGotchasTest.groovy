package com.holi.traits

import org.junit.Test

/**
 * Created by selonj on 16-8-1.
 */
class StateGotchasTest {
  trait Valuable {
    def value = 1;

    def property() {
      return value;
    }

    def get() {
      return getValue();
    }
  }

  class Number implements Valuable {
    def value = 2;
  }

  @Test void 'call property will using property in trait'() {
    def number = new Number();

    assert number.property() == 1;
    assert (number as Valuable).property() == 1;
  }

  @Test void 'call getter/setter supports override'() {
    def number = new Number();

    assert number.get() == 2;
    assert (number as Valuable).get() == 2;
  }
}
