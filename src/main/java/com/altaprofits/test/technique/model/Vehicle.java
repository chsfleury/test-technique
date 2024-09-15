package com.altaprofits.test.technique.model;

import java.io.IOException;
import java.io.Writer;

public interface Vehicle {

  long getId();
  String getName();

  default void print(Writer writer) throws IOException {
    writer.write(getClass().getSimpleName() + " (id=" + getId() + ", name=" + getName() + ")");
  }

}
