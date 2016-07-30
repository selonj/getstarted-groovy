package com.holi.operators

import org.junit.Test

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by selonj on 16-7-30.
 */
class RegexExpressionOperatorsTest {
  @Test void 'a simple way to create a java.util.regex.Pattern instance by ~ before any String or GString'() {
    def anyString = 'any string';
    def anyGString = "$anyString";

    assert (~/test/) instanceof Pattern;
    assert (~anyString) instanceof Pattern;
    assert (~anyGString) instanceof Pattern;
  }

  @Test void 'use the find operator =~ to build a java.util.regex.Matcher instance'() {
    assert ('any' =~ /regex string/) instanceof Matcher;
  }

  @Test void 'use the match operator ==~ matches string with regex string'() {
    assert ('any' ==~ 'regex string') instanceof Boolean;
    assert ('foo' ==~ 'f.*');
    assert !('foo' ==~ 'f');
  }
}
