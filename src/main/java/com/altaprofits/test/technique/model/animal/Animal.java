package com.altaprofits.test.technique.model.animal;

public interface Animal {

  String getId();
  String getName();

  default void move() {
    // Move animal
  }

}
