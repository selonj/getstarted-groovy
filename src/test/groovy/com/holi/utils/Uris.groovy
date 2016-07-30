package com.holi.utils

/**
 * Created by selonj on 16-7-30.
 */
class Uris {
  static URI classpath(String uri) {
    return ClassLoader.systemClassLoader.getResource(uri).toURI();
  }
}
