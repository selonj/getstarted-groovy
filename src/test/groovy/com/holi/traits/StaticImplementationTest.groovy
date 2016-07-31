package com.holi.traits

import org.junit.Test

/**
 * Created by selonj handle 16-7-31.
 */
class StaticImplementationTest {
  class ExtendedEmptyTrait implements EmptyTrait {}

  @Test void 'class implements trait is a trait'() {
    assert EmptyTrait.isAssignableFrom(ExtendedEmptyTrait);
  }

  class ExtendedTraitDefinedPublicMethod implements TraitDefinedPublicMethod {}

  @Test void 'class implements trait will inherit its public methods'() {
    def implementation = new ExtendedTraitDefinedPublicMethod();

    assert implementation.exec() == 'success';
  }

  class ExtendedTraitDefinedProperty implements TraitDefinedProperty {}

  @Test void 'class implements trait will inherit its properties'() {
    def implementation = new ExtendedTraitDefinedProperty();

    assert implementation.state == 'initial';

    implementation.state = 'destroyed';
    assert implementation.state == 'destroyed';
  }

  class ExtendedTraitDefinedAbstractMethod implements TraitDefinedAbstractMethod {
    def ran = false;

    @Override
    void run() {
      ran = true;
    }
  }

  @Test void 'class implements trait with abstract method must implement the method'() {
    def implementation = new ExtendedTraitDefinedAbstractMethod();

    assert !implementation.ran;

    implementation.run();
    assert implementation.ran;
  }

  class ExtendedTraitDefinedPrivateMethod implements TraitDefinedPrivateMethod {
  }

  @Test void 'class implements trait with private method will not inherited'() {
    assert !('run' in TraitDefinedPrivateMethod.methods*.name);
    assert !('run' in ExtendedTraitDefinedPrivateMethod.methods*.name);
  }

  class ExtendedTraitWithinThis implements TraitWithinThis {}

  @Test void 'traits within this represents the implementing instance'() {
    def implementation = new ExtendedTraitWithinThis();

    assert implementation.owner().is(implementation);
  }

  @Test void 'trait implements interface'() {
    assert Runnable.isAssignableFrom(TraitImplementsInterface);
  }

  class ExtendedTraitDefinedPrivateField implements TraitDefinedPrivateField {}

  @Test void 'class implements trait defined private field will not inherited and not appear on trait contract interface'() {
    assert !('field' in TraitDefinedPrivateField.fields*.name);
    assert !('field' in ExtendedTraitDefinedPrivateField.fields*.name);
  }

  class ExtendedTraitDefinedPublicField implements TraitDefinedPublicField {
  }

  @Test void 'trait with public field names are remapped in the implementing class'() {
    def implementation = new ExtendedTraitDefinedPublicField();

    assert implementation.com_holi_traits_StaticImplementationTest$TraitDefinedPublicField__field == 'value';
  }

  class OverridingTraitDefinedPublicMethod implements TraitDefinedPublicMethod {
    @Override
    def exec() {
      return 'none';
    }
  }

  @Test void 'class overriding default trait method'() {
    def implementation = new OverridingTraitDefinedPublicMethod();

    assert implementation.exec() == 'none';
  }

  @Test void 'trait can call any dynamic code'() {
    def implementation = new ExtendedTraitWithinDynamicCode();

    assert implementation.speak() == implementation.quark();
  }

  class ExtendedTraitWithinDynamicCode implements TraitWithinDynamicCode {
    String quark() {
      return 'foo';
    }
  }

  static trait TraitWithinDynamicCode {
    String speak() {
      return quark();
    }
  }

  static trait EmptyTrait {
  }

  static trait TraitDefinedAbstractMethod {
    abstract void run();
  }

  static trait TraitDefinedPrivateField {
    private def field;
  }

  static trait TraitDefinedPrivateMethod {
    private void run() {}
  }

  static trait TraitDefinedProperty {
    String state = "initial";
  }

  static trait TraitDefinedPublicField {
    private def field = 'value';
  }

  static trait TraitDefinedPublicMethod {
    def exec() {
      return 'success';
    }
  }

  static trait TraitImplementsInterface implements Runnable {
  }

  static trait TraitWithinThis {
    def owner() {
      return this;
    }
  }
}
