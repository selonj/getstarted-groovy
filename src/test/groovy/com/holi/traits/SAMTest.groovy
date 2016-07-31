package com.holi.traits

import org.junit.Test

/**
 * Created by selonj on 16-7-31.
 */
class SAMTest {
  @Test void 'convert closure as SAM implementation'() {
    Greeting toJohn = { return 'john'; };

    assert toJohn.greeting() == 'Hi, john';
  }

  trait Greeting {
    String greeting() {
      return "Hi, ${name}";
    }

    abstract def getName();
  }
}
