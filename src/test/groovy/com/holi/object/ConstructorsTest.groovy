package com.holi.object

import org.codehaus.groovy.runtime.metaclass.MethodSelectionException
import org.junit.Test
import java.sql.Date as SQLDate

import static groovy.test.GroovyAssert.shouldFail;

/**
 * Created by selonj on 16-7-31.
 */
class ConstructorsTest {

  @Test void 'create instance using coercion with as keyword'() {
    def date = [1] as Date;

    assert date.time == 1;
  }

  @Test void 'create instance using coercion defined variable type'() {
    Date date = [1];

    assert date.time == 1;
  }

  @Test void 'passing parameters in the form of a map to constructor if default constructor exists'() {
    def date = new Date(time: 1);

    assert date.time == 1;

    shouldFail(MethodSelectionException) {
      new SQLDate(time: 1);
    }
  }
}
