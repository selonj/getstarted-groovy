package com.holi.object

import groovy.transform.AnnotationCollector
import org.junit.Test

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * Created by selonj on 16-7-31.
 */
@Condition({ return profile == 'dev'; })
class AnnotationsTest {

  @Test void 'annotated with closure'() {
    def condition = AnnotationsTest.getAnnotation(Condition);
    Closure validator = condition.value().newInstance(this, this);

    validator.delegate = [profile: 'dev'];
    assert validator.call();

    validator.delegate = [profile: 'product'];
    assert !validator.call();
  }

  @TransactionalService
  class MetaAnnotation {
  }

  @Test void 'define meta annotation with AnnotationCollector'() {
    assert !MetaAnnotation.isAnnotationPresent(TransactionalService); //meta annotation will replace with below annotations
    assert MetaAnnotation.isAnnotationPresent(Transactional);
    assert MetaAnnotation.isAnnotationPresent(Service);
  }

  @TransactionalService(readOnly = true, type = 'http', value = 'aliasing')
  class MetaAnnotationOverridingAttributes {
  }

  @Test void 'meta annotation replace annotation with attributes '() {
    def transactional = MetaAnnotationOverridingAttributes.getAnnotation(Transactional);
    def service = MetaAnnotationOverridingAttributes.getAnnotation(Service);

    assert transactional.readOnly();
    assert service.type() == 'http';

    assert transactional.value() == 'aliasing';
    assert service.value() == 'aliasing';
  }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Condition {
  Class value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Transactional {
  String value() default '';

  boolean readOnly() default false;
}

@Retention(RetentionPolicy.RUNTIME)
@interface Service {
  String value() default '';

  String type() default '';
}

@Transactional
@Service
@AnnotationCollector
@interface TransactionalService {
}
