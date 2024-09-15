package com.altaprofits.test.technique.model;

import com.altaprofits.test.technique.model.vehicle.AirPlane;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTest {

  @Test
  public void shouldPrintVehicle() throws IOException {
    AirPlane airPlane = new AirPlane(1, "Spitfire");
    StringWriter writer = new StringWriter();
    airPlane.print(writer);

    assertThat(writer.toString()).isEqualTo("AirPlane (id=1, name=Spitfire)");
  }

}