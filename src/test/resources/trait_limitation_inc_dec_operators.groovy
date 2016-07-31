import groovy.transform.Trait

@Trait
class Property {
  int value;

  void inc() {
    value++;
  }

  void dec() {
    value--;
  }
}

return true;