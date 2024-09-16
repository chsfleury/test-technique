package com.altaprofits.test.technique.model.vehicle;

import com.altaprofits.test.technique.model.Floating;
import com.altaprofits.test.technique.model.Flying;
import com.altaprofits.test.technique.model.building.HangarSection;
import com.altaprofits.test.technique.model.utils.UID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class SeaPlane implements Flying, Floating, Vehicle {

  private final String id;
  private final String name;

  public SeaPlane(String name) {
    this.id = UID.generate();
    this.name = name;
  }

  @Override
  public HangarSection getSection() {
    return HangarSection.PORT;
  }

}
