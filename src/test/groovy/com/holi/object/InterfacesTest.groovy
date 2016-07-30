package com.holi.object

import org.junit.Test

/**
 * Created by selonj on 16-7-31.
 */
class InterfacesTest {
  @Test void 'make an instance of an object implement an interface at runtime, using the as coercion operator'() {
    def executed;
    def action = new Object() {
      def run() {
        executed = true;
      }
    };

    def task = action as Runnable;
    assert !executed;

    task.run();
    assert executed;
  }
}
