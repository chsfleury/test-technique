package com.altaprofits.test.technique.model.vehicle;

import com.altaprofits.test.technique.model.Rolling;
import com.altaprofits.test.technique.model.building.HangarSection;
import com.altaprofits.test.technique.model.utils.UID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
public class Car implements Rolling, Vehicle {

  private final String id;
  private final String name;

  public Car(String name) {
    this.id = UID.generate();
    this.name = name;
  }

  @Override
  public HangarSection getSection() {
    return HangarSection.GARAGE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return id == car.id;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
