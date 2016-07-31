package com.holi.traits

import com.holi.utils.Uris
import org.codehaus.groovy.control.CompilationFailedException
import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-8-1.
 */
class LimitationsTest {
  def shell = new GroovyShell();

  @Test void '++/-- not support in trait field'() {
    shouldFail(CompilationFailedException) {
      shell.evaluate(Uris.classpath('trait_limitation_inc_dec_operators.groovy'));
    }
  }
}
