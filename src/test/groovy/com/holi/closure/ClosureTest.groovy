package com.holi.closure

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-8-1.
 */
class ClosureTest {
  @Test void 'closure is a instance groovy.lang.Closure'() throws Exception {
    assert {} instanceof Closure;
  }

  @Test void 'calling closure'() {
    def hex = { int digit -> return Character.forDigit(digit, 16); };

    assert hex(15) == 'f' as char; //calling by () operator
    assert hex.call(15) == 'f' as char; //calling by call method explicitly
  }

  @Test void 'parameters with default value'() {
    def times = { int number, int times = 2 ->
      return number * times;
    };

    assert times(2) == 4;
    assert times(2, 3) == 6;
  }

  @Test void 'implicit parameter \'it\''() {
    def dump = { return it; };

    assert dump() == null;
    assert dump(1) == 1;
    assert dump([]) == [];
  }

  @Test void 'varargs'() {
    def concat = { String... strings -> return strings.join(','); };

    assert concat('foo', 'bar') == 'foo,bar';
    assert concat((String[]) ['foo', 'bar']) == 'foo,bar';
  }

  @Test void 'properties'() {
    def empty = {};

    assert empty.thisObject == this;
    assert empty.owner == this;
    assert empty.delegate == this;
  }

  @Test void 'lazy evaluation in gstring'() {
    def type = 'json';
    def view = "${-> type}";

    assert view == 'json';

    type = 'html';
    assert view == 'html';
  }
  def div = { int a, b -> return a / b; };

  @Test void 'left curry'() {
    assert div.curry(6)(2) == div(6, 2);
    assert div.curry(6, 2)() == div(6, 2);
  }

  @Test void 'left ncurry'() {
    assert div.ncurry(0, 6)(2) == div(6, 2);
    assert div.ncurry(0, 6, 2)() == div(6, 2);
    assert div.ncurry(-1, 2)(6) == div(6, 2);
  }

  @Test void 'right ncurry'() {
    assert div.rcurry(2)(6) == div(6, 2);
    assert div.rcurry(6, 2)() == div(6, 2);
  }

  @Test void 'memorizing'() {
    def called = false;
    def fun = {
      if (called) throw new IllegalStateException();
      called = true;
    };
    fun(); //ok

    shouldFail(IllegalStateException) {
      fun();
    }

    def memorized = fun.memoize();
    called = false;

    memorized(); //ok
    memorized(); //ok
  }

  @Test void 'composition'() {
    def plus2 = { return it + 2 };
    def times3 = { return it * 3 };

    def times3plus2 = plus2 << times3;
    assert times3plus2(3) == plus2(times3(3));

    def plus2times3 = plus2 >> times3;
    assert plus2times3(3) == times3(plus2(3));
  }

  @Test void 'method pointer'() {
    def first = new BigInteger(1);

    def next = first.&add.curry(1g);

    assert first == 1g;
    assert next() == 2g;
  }
}
