package com.holi.operators

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-7-30.
 */
class SpreadOperatorsTest {
  @Test void 'invoke an action on all items of an aggregate object'() {
    def map = [foo: 'bar', key: 'value'];

    assert map*.key == ['foo', 'key'];
  }

  @Test void 'the spread operator is null-safe, meaning that if an element of the collection is null, it will return null instead of throwing a NullPointerException'() {
    def numbers = [1, null, 2];

    assert numbers*.plus(2) == [3, null, 4];
  }

  @Test void 'the receiver might also be null, in which case the return value is null'() {
    assert null*.any == null;
  }

  @Test void 'the spread operator can use in any array or Iterable'() {
    int[] array = [1, 2, 3];
    def list = [1, 2, 3];

    assert array*.plus(2) == [3, 4, 5];
    assert list*.plus(2) == [3, 4, 5];
    assert list.iterator()*.plus(2) == [3, 4, 5];
  }

  int function(int x, int y, int z) {
    return x * y + z;
  }

  @Test void 'spreading method arguments'() {
    def argsLengthMatchingFunctionArgumentsLength = [2, 3, 4];
    def argsLengthGreaterThanFunctionArgumentsLength = [2, 3, 4, 5];

    assert function(*argsLengthMatchingFunctionArgumentsLength) == 10;

    shouldFail(MissingMethodException) {
      function(*argsLengthGreaterThanFunctionArgumentsLength);
    }
  }

  @Test void 'spreading method arguments mix normal arguments with spread ones'() {
    def spreadArgs = [2, 3];

    assert function(*spreadArgs, 4) == 2 * 3 + 4;
    assert function(4, *spreadArgs) == 4 * 2 + 3;
  }

  @Test void 'the spread operator use inside a list literal, acts as if the spread element contents were inlined into the list'() {
    assert [1, *[2, 3], 4] == [1, 2, 3, 4];
  }

  @Test void 'the spread operator use inside a map literal, acts as if the spread map entries were inlined into the map'() {
    assert [foo: 'bar', *: [key: 'value']] == [foo: 'bar', key: 'value'];
  }
}
