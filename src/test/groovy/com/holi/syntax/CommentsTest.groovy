#!/user/bin/env groovy
package com.holi.syntax

import com.holi.utils.Uris
import org.junit.Test

/**
 * Created by selonj on 16-7-29.
 */
class CommentsTest {
  static final String FOO = 'foo'
  static final String BAR = 'bar'
  String value = BAR;

  @Test void 'no comments'() {
    String value = FOO;
    assert value == FOO;
  }

  @Test void 'single line comment'() {
    //String value = FOO;
    assert value == BAR;
  }

  @Test void 'multi line comment'() {
    /*
     String value = FOO;
    */
    assert value == BAR;
  }

  @Test void 'doc comment'() {
    /**
     * @author holi
     * String value = FOO;
     */
    assert value == BAR;
  }

  @Test void 'shell comment line "#" must be the first character of the groovy source file'() {
    GroovyShell shell = new GroovyShell();
    def result = shell.evaluate(Uris.classpath('shell_comment_line.groovy'));
    assert result == 'success';
  }
}
