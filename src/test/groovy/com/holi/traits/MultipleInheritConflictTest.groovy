package com.holi.traits

import org.junit.Test

/**
 * Created by selonj on 16-8-1.
 */
class MultipleInheritConflictTest {
  trait Foo {
    def defaults() { return 'foo'; }

    def explicit() { return 'foo'; }
  }

  trait Bar {
    def defaults() { return 'bar'; }

    def explicit() { return 'foo'; }
  }

  class Explicit implements Foo, Bar {
    def explicit() {
      return Foo.super.explicit();
    }
  }

  @Test void 'the last declared trait wins the default conflict resolution'() {
    assert 'anything'.withTraits(Bar, Foo).defaults() == 'foo';
    assert 'anything'.withTraits(Foo, Bar).defaults() == 'bar';
  }

  @Test void 'calls explicit solving conflict resolution'() {
    def implementation = new Explicit();

    assert implementation.explicit() == 'foo';
  }
}
