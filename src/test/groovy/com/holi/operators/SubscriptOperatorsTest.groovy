package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class SubscriptOperatorsTest {
  class Arguments {
    private def values;

    def getAt(int index) {
      return values[index];
    }

    def putAt(int index, def value) {
      values[index] = value;
    }
  }

  @Test void 'the subscript operator [] is a short hand notation for getAt or putAt, depending on whether you find it on the left hand side or the right hand side of an assignment'() {
    def args = new Arguments(values: [1, 2, 3]);

    assert args[0] == 1;

    args[0] = -1;
    assert args[0] == -1;
  }

  @Test void 'getAt also supports ranges'() {
    def numbers = [1, 2, 3];
    assert numbers[0..1] == [1, 2];
  }

  @Test void 'putAt also supports ranges'() {
    def numbers = [1, 2, 3];

    numbers[0..1] = [-1, -1];

    assert numbers == [-1, -1, 3];
  }
}
