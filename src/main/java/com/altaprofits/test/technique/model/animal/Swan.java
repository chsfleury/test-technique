package com.altaprofits.test.technique.model.animal;

import com.altaprofits.test.technique.model.Floating;
import com.altaprofits.test.technique.model.Flying;
import com.altaprofits.test.technique.model.utils.UID;
import lombok.Getter;

@Getter
public class Swan implements Animal, Flying, Floating {

  private final String id;
  private final String name;

  public Swan(String name) {
    this.id = UID.generate();
    this.name = name;
  }

}
