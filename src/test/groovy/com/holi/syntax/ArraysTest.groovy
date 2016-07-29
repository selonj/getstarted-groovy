package com.holi.syntax

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class ArraysTest {
  @Test void 'explicit define array type of a list'() {
    String[] items = ['foo', 'bar'];

    assert items.class == String[];
  }

  @Test void 'multi dimension array'() {
    def items = new Integer[3][3];

    assert items.class == Integer[][];
  }
}
