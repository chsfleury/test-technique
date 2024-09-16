package com.altaprofits.test.technique.model.vehicle;

import com.altaprofits.test.technique.model.Flying;
import com.altaprofits.test.technique.model.building.HangarSection;
import com.altaprofits.test.technique.model.utils.UID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
public class AirPlane implements Flying, Vehicle {

  private final String id;
  private final String name;

  public AirPlane(String name) {
    this.id = UID.generate();
    this.name = name;
  }

  @Override
  public HangarSection getSection() {
    return HangarSection.AIRPORT;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AirPlane airPlane = (AirPlane) o;
    return id == airPlane.id;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

}
