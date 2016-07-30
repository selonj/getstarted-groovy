package com.holi.structure

import com.holi.utils.Uris
import org.junit.Test

import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by selonj on 16-7-30.
 */
class ImportsTest {
  def shell = new GroovyShell();

  @Test void 'default imports'() {
    def year = shell.evaluate(Uris.classpath('default_imports.groovy'));

    assert year == new Date().year;
  }

  @Test void 'simple import'() {
    AtomicBoolean result = shell.evaluate(Uris.classpath('simple_import.groovy'));

    assert result.get();
  }

  @Test void 'star import import all classes in package'() {
    AtomicBoolean result = shell.evaluate(Uris.classpath('star_import.groovy'));

    assert result.get();
  }

  @Test void 'static import capability allows you to reference imported classes as if they were static methods/fields in your own class'() {
    boolean result = shell.evaluate(Uris.classpath('static_import.groovy'));

    assert result;
  }

  @Test void 'static imports with the as keyword provide an elegant solution to namespace problems. '() {
    def year = shell.evaluate(Uris.classpath('static_import_aliasing.groovy'));

    assert year == Calendar.getInstance()[Calendar.YEAR];
  }

  @Test void 'a static star import will import all the static methods from the given class.'() {
    int result = shell.evaluate(Uris.classpath('static_star_import.groovy'));

    assert result == Math.pow(2, 3) + Math.floorMod(2, 3);
  }

  @Test void 'aliasing import can refer to a fully qualified class name using a name of our choice.'() {
    def result = shell.evaluate(Uris.classpath('import_aliasing.groovy'));

    assert result instanceof Date;
  }
}
