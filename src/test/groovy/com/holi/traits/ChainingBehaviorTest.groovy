package com.holi.traits

import org.junit.Test

/**
 * Created by selonj handle 16-7-31.
 */
class ChainingBehaviorTest {

  @Test void 'chaining behavior within \'super\' keyword'() {
    //implements Proxy pattern,as interceptor
    def handler = new SimpleMessageHandler().withTraits(LoggingMessageHandler, FilteringMessageHandler);

    assert handler.handle(true) == ['simple', 'logging'];
    assert handler.handle(false) == null; //filtered
  }

  interface MessageHandler {
    List<String> handle(profile);
  }

  class SimpleMessageHandler implements MessageHandler {
    List<String> handle(profile) {
      return ['simple'];
    }
  }

  trait LoggingMessageHandler implements MessageHandler {
    List<String> handle(profile) {
      return super.handle(profile) << 'logging';
    }
  }

  trait FilteringMessageHandler implements MessageHandler {
    List<String> handle(profile) {
      if (profile) {
        return super.handle(profile);
      };
      return null;
    }
  }
}

