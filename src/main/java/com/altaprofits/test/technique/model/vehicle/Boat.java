package com.altaprofits.test.technique.model.vehicle;

import com.altaprofits.test.technique.model.FloatingVehicle;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Boat implements FloatingVehicle {

  private final long id;
  private final String name;

}
