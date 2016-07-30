package com.holi.object

import groovy.transform.PackageScope
import org.junit.Test

import java.lang.reflect.Modifier

/**
 * Created by selonj on 16-7-31.
 */
class PropertiesTest {
  def final readonly;
  @PackageScope def packaged;
  private def privacy;
  public def publicly;
  protected def protect;
  def optional;

  private int modifiers(String fieldName) {
    return PropertiesTest.getDeclaredField(fieldName).modifiers;
  }

  @Test void 'each field will defined as private if no access modifier presented'() {
    assert Modifier.isPrivate(modifiers('readonly'));
    assert Modifier.isPrivate(modifiers('privacy'));
    assert Modifier.isPrivate(modifiers('optional'));
    assert isPackage(modifiers('packaged'));
    assert Modifier.isProtected(modifiers('protect'));
    assert Modifier.isPublic(modifiers('publicly'));
  }

  @Test void 'final field with no setter'() {
    assert !respondsTo('setReadonly');
    assert respondsTo('getReadonly');
  }

  @Test void 'package scope field with no getter&setter'() {
    assert !respondsTo('setPackaged');
    assert !respondsTo('getPackaged');
  }

  @Test void 'private scope field with no getter&setter'() {
    assert !respondsTo('setPrivacy');
    assert !respondsTo('getPrivacy');
  }

  @Test void 'protected scope field with no getter&setter'() {
    assert !respondsTo('setProtect');
    assert !respondsTo('getProtect');
  }

  @Test void 'public scope field with getter&setter'() {
    assert !respondsTo('setPublicly');
    assert !respondsTo('getPublicly');
  }

  @Test void 'no scope field with getter&setter'() {
    assert respondsTo('setOptional');
    assert respondsTo('getOptional');
  }

  private boolean isPackage(int var) {
    return (var & (Modifier.PUBLIC | Modifier.PROTECTED | Modifier.PRIVATE)) == 0;
  }
}
