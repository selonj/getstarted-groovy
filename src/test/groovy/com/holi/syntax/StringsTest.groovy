package com.holi.syntax

import org.junit.Test

import java.util.concurrent.atomic.AtomicBoolean

import static groovy.test.GroovyAssert.shouldFail

/**
 * Created by selonj on 16-7-30.
 */
class StringsTest {

  @Test void 'single quoted string is a String'() {
    assert 'a' instanceof String;
  }

  @Test void 'triple single quoted string is a String'() {
    assert '''1''' instanceof String;
  }

  @Test void 'triple single quoted string for multiline string will but keep linebreak chars'() {
    def string = '''
    first
    last
    ''';

    assert string.find(~/\n/);
  }

  @Test void 'triple single quoted string escaping newline by \\'() {
    def string = '''\
                  first\
                  last\
                 ''';

    assert !string.find(~/\n/);
  }

  @Test void 'double quoted string is a String when there is no interpolated expression'() {
    assert "string" instanceof String;
  }

  @Test void 'double quoted string is a GString when there is interpolated expression'() {
    assert "$this" instanceof GString;
  }

  @Test void 'escape double quoted string interpolated expression with \\'() {
    assert "\$this" instanceof String;
  }

  @Test void 'throws MissingPropertyException when interpolate method expression without {}'() {
    def number = 1;
    shouldFail(MissingPropertyException) {
      "$number.toString()";
    };
    assert "${number.toString()}" == number.toString();
  }

  @Test void 'holds reference in gstring'() {
    def ran = new AtomicBoolean(false);
    def result = "${ran}";

    assert result == 'false';

    ran.set(true);

    assert result == 'true';
  }

  @Test void 'interpolating closure expressions'() {
    assert "1 + 2 = ${-> 3}".toString() == '1 + 2 = 3';
    assert "1 + 2 = ${out -> out << 3}".toString() == '1 + 2 = 3'; //take PrintWriter parameter
  }

  @Test void 'interpolating closure expressions initialization'() {
    def number = 1;
    def lazyInitialized = "${-> number}";
    def eagerInitialized = "${number}";

    assert lazyInitialized.toString() == "1";
    assert eagerInitialized.toString() == "1";

    //after number changed
    number = 2;
    assert lazyInitialized.toString() == "2"; //changed
    assert eagerInitialized.toString() == "1";
  }

  @Test void 'convert GString to String with java automatically'() {
    def number = 1;
    String string = "$number";

    assert string instanceof String;
  }

  @Test void "can't convert String to GString with java automatically"() {
    shouldFail(ClassCastException) {
      GString string = '$number';
    }
  }

  @Test void "GString and String hashCode are different"() {
    assert '1'.hashCode() != "${1}".hashCode()
  }

  @Test void "triple double quoted string can having interpolated expressions"() {
    assert """${1}""".toString() == '1';
  }

  @Test void "triple single quoted string having no interpolated expressions"() {
    assert '''${1}'''.toString() == '${1}';
  }

  @Test void "slashy string is a String when there is no interpolated expressions"() {
    assert (/abc/) instanceof String;
  }

  @Test void "slashy string is a GString when there is interpolated expressions"() {
    assert (/${0}/) instanceof GString;
  }

  @Test void "slashy string for multiline will keep linebreak chars"() {
    def string = /
     foo
    /;

    assert string.find(~/\n/);
  }

  @Test void "slashy string for multiline escape new line with \\"() {
    def string = /\
     foo\
    /;

    assert !string.find(~/ \n /);
  }

  @Test void "dollar slashy string is a String when there is no interpolated expressions"() {
    assert ($/abc/$) instanceof String;
  }

  @Test void "dollar slashy string is a GString when there is interpolated expressions"() {
    assert ($/${0}/$) instanceof GString;
  }

  @Test void "dollar slashy string for multiline will keep linebreak chars"() {
    def string = $/
     foo
    /$;

    assert string.find(~/\n/);
  }

  @Test void "dollar slashy string for multiline escape new line with \\"() {
    def string = $/\
     foo\
    /$;

    assert !string.find(~/ \n /);
  }

  @Test void "dollar slashy string escape char is \$"() {
    assert ($/$${0}/$) == '${0}';
  }
}
