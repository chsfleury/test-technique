package com.altaprofits.test.technique.model.vehicle;

import com.altaprofits.test.technique.model.Floating;
import com.altaprofits.test.technique.model.building.HangarSection;
import com.altaprofits.test.technique.model.utils.UID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
public class JetSki implements Floating, Vehicle {

  private final String id;
  private final String name;

  public JetSki(String name) {
    this.id = UID.generate();
    this.name = name;
  }

  @Override
  public HangarSection getSection() {
    return HangarSection.PORT;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JetSki jetSki = (JetSki) o;
    return id == jetSki.id;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
