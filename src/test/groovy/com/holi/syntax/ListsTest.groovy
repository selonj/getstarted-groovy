package com.holi.syntax

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class ListsTest {
  @Test void 'list type'() {
    assert [1, 2, 3].class == ArrayList;
  }

  @Test void 'access list item as array with []'() {
    def numbers = [1, 2];

    assert numbers[0] == 1;
    assert numbers[1] == 2;
  }

  @Test void 'add item in list by <<'() {
    def numbers = [];

    numbers << 1;
    numbers << 2;

    assert numbers == [1, 2];
  }
}
