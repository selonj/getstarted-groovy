package com.holi.syntax

import org.junit.Test

/**
 * Created by selonj on 16-7-30.
 */
class NumbersTest {
  @Test void 'explict define number type'() {
    byte byteValue = 1;
    short shortValue = 1;
    int intValue = 1;
    long longValue = 1;
    float floatValue = 1;
    double doubleValue = 1;
    BigInteger bigIntegerValue = 1;
    BigDecimal bigDecimalValue = 1;

    assert byteValue.class == Byte;
    assert shortValue.class == Short;
    assert intValue.class == Integer;
    assert longValue.class == Long;
    assert floatValue.class == Float;
    assert doubleValue.class == Double;
    assert bigIntegerValue.class == BigInteger;
    assert bigDecimalValue.class == BigDecimal;
  }

  @Test void 'adapt number literal type with its capacity automatically'() {
    //positive numbers
    assert 2147483647.class == Integer; //Integer.MAX_VALUE
    assert 2147483648.class == Long; //Integer.MAX_VALUE + 1
    assert 9223372036854775807.class == Long; //Long.MAX_VALUE
    assert 9223372036854775808.class == BigInteger; //Long.MAX_VALUE + 1

    //negative numbers
    assert (-2147483648).class == Integer; //Integer.MIN_VALUE
    assert (-2147483649).class == Long; //Integer.MIN_VALUE - 1
    assert (-9223372036854775808).class == Long; //Long.MIN_VALUE
    assert (-9223372036854775809).class == BigInteger; //Long.MIN_VALUE - 1

    //variables can't adapted
    assert (Integer.MAX_VALUE + 1).class == Integer;
  }

  @Test void 'binary literal'() {
    def number = 0b111;

    assert number == 1 * 2 * 2 + 1 * 2 + 1;
  }

  @Test void 'hex literal'() {
    def number = 0xff;

    assert number == 15 * 16 + 15;
  }

  @Test void 'octal literal'() {
    def number = 077;
    assert number == 7 * 8 + 7;
  }

  @Test void 'underscore literal'() {
    def currency = 1_000;
    assert currency == 1000;
  }

  @Test void 'number with suffix'() {
    assert 1i.class == Integer;
    assert 1l.class == Long;
    assert 1g.class == BigInteger;
    assert 1f.class == Float;
    assert 1d.class == Double;
    assert 1.0g.class == BigDecimal;
  }

  @Test void 'number with suffix case insensitive'() {
    assert 1i == 1;
    assert 1i.class == 1I.class;
    assert 1i == 1I;
  }
}
