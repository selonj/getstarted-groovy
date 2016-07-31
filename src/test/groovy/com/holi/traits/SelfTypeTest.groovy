package com.holi.traits

import com.holi.utils.Uris
import groovy.transform.CompileStatic
import groovy.transform.SelfType
import org.codehaus.groovy.control.CompilationFailedException
import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-8-1.
 */
class SelfTypeTest {
  def shell = new GroovyShell();

  @Test void 'makes the type checker aware of the type of itself by @SelfType'() {
    shell.evaluate(Uris.classpath('trait_self_type.groovy')); //ok

    shouldFail(CompilationFailedException) {
      shell.evaluate(Uris.classpath('trait_self_type_mismatch.groovy')); //failed
    }
  }

  @SelfType([Runnable])
  @CompileStatic
  trait TaskFilter {
  }
}
