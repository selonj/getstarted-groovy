package com.holi.syntax

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-7-30.
 */
class IdentifiersTest {
  private final GroovyShell shell = new GroovyShell();

  @Test void 'normal identifiers'() {
    def $amount = 1, foo = 'bar', _ = '', key1 = 'value';

    assert $amount == 1;
    assert foo == 'bar';
    assert _ == '';
    assert key1 == 'value';
  }

  @Test void 'single $ identifier is not valid for variable'() {
    shouldFail('def $="something"');
  }

  @Test void 'single $ identifier is valid for method identifier'() {
    assert $() == 'ok';
  }

  String $() { return 'ok'; };

  @Test void 'quoted identifiers'() {
    def map = ['code base': 'example.com'];

    assert map.'code base' == 'example.com';
  }

  private void shouldFail(String code) {
    shouldFail {
      shell.evaluate(code, 'test');
    };
  }
}
