package com.altaprofits.test.technique.model.vehicle;

import com.altaprofits.test.technique.model.RollingVehicle;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Motorcycle implements RollingVehicle {

  private final long id;
  private final String name;

}
