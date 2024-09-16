package com.altaprofits.test.technique.model.vehicle;

import com.altaprofits.test.technique.model.building.HangarSection;

import java.io.IOException;
import java.io.Writer;

public interface Vehicle {

  String getId();
  String getName();

  HangarSection getSection();

  default void print(Writer writer) throws IOException {
    writer.write(getClass().getSimpleName() + " (id=" + getId() + ", name=" + getName() + ")");
  }

  default void move() {
    // Move Vehicle
  }

}
