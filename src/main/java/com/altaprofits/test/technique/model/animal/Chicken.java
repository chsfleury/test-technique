package com.altaprofits.test.technique.model.animal;

import com.altaprofits.test.technique.model.Flying;
import com.altaprofits.test.technique.model.utils.UID;
import lombok.Getter;

@Getter
public class Chicken implements Animal, Flying {

  private final String id;
  private final String name;

  public Chicken(String name) {
    this.id = UID.generate();
    this.name = name;
  }

}
