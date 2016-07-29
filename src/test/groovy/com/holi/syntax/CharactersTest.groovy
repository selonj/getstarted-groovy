package com.holi.syntax

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-7-30.
 */
class CharactersTest {

  @Test void 'explicit define variable type with "char"'() {
    char value = 'a';

    assert value.class == Character;
  }

  @Test void 'convert variable as "char" using "as" keyword'() {
    def value = 'a' as char;

    assert value.class == Character;
  }

  @Test void 'convert variable as "char" using cast operator (type)'() {
    def value = (char) 'a';

    assert value.class == Character;
  }

  @Test void "can't convert single string to char automatically with parameters"() {
    shouldFail(MissingMethodException) {
      upperCase('a');
    }
  }

  char upperCase(char c) {
    return c.upperCase;
  }
}
