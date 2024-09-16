package com.altaprofits.test.technique.model.animal;

import com.altaprofits.test.technique.model.Floating;
import com.altaprofits.test.technique.model.utils.UID;
import lombok.Getter;

@Getter
public class Frog implements Animal, Floating {

  private final String id;
  private final String name;

  public Frog(String name) {
    this.id = UID.generate();
    this.name = name;
  }
}
