package com.holi.operators

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class AssignmentArithmeticOperatorsTest {
  def six = 6, two = 2;

  @Test void 'plus +='() {
    six += two;
    assert six == 8;
  }

  @Test void 'minus -='() {
    six -= two;
    assert six == 4;
  }

  @Test void 'multiply *='() {
    six *= two;
    assert six == 12;
  }

  @Test void 'div /='() {
    six /= two;
    assert six == 3;
  }

  @Test void 'mod %='() {
    six %= two;
    assert six == 0;
  }

  @Test void 'power **='() {
    six **= two;
    assert six == 36;
  }
}
