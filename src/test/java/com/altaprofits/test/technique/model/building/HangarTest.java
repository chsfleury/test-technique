package com.altaprofits.test.technique.model.building;

import com.altaprofits.test.technique.model.vehicle.AirPlane;
import com.altaprofits.test.technique.model.vehicle.Boat;
import com.altaprofits.test.technique.model.vehicle.Car;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class HangarTest {

  @Test
  public void testEmptyHangar() throws IOException {
    Hangar hangar = new Hangar();
    assertThat(hangar.portVehicleCount()).isEqualTo(0);
    assertThat(hangar.airportVehicleCount()).isEqualTo(0);
    assertThat(hangar.garageVehicleCount()).isEqualTo(0);
    assertThat(hangar.totalVehicleCount()).isEqualTo(0);
    checkPrint("", hangar);
  }

  @Test
  public void testFullHangar() throws IOException {
    Hangar hangar = new Hangar();

    Car car = new Car("Peugeot");
    hangar.add(car);

    Boat boat = new Boat("Voilier");
    hangar.add(boat);

    AirPlane airplane = new AirPlane("Spitfire");
    hangar.add(airplane);

    assertThat(hangar.portVehicleCount()).isEqualTo(1);
    assertThat(hangar.airportVehicleCount()).isEqualTo(1);
    assertThat(hangar.garageVehicleCount()).isEqualTo(1);
    assertThat(hangar.totalVehicleCount()).isEqualTo(3);
    checkPrint(
        """
            AirPlane (id=%s, name=Spitfire)
            Boat (id=%s, name=Voilier)
            Car (id=%s, name=Peugeot)
            """.stripIndent()
            .formatted(airplane.getId(), boat.getId(), car.getId()),
        hangar
    );
  }

  @Test
  public void testPrintToFile() throws IOException {
    Path testFile = Files.createTempFile("testHangar", "");
    Hangar hangar = new Hangar();

    Car car = new Car("Peugeot");
    hangar.add(car);

    Boat boat = new Boat("Voilier");
    hangar.add(boat);

    AirPlane airplane = new AirPlane("Spitfire");
    hangar.add(airplane);

    hangar.printToFile(testFile);

    String actual = Files.readString(testFile);
    checkSameLines(
        actual,
        """
            AirPlane (id=%s, name=Spitfire)
            Boat (id=%s, name=Voilier)
            Car (id=%s, name=Peugeot)
            """.stripIndent()
            .formatted(airplane.getId(), boat.getId(), car.getId())
    );
  }

  private void checkPrint(String expected, Hangar hangar) throws IOException {
    StringWriter writer = new StringWriter();
    BufferedWriter bufferedWriter = new BufferedWriter(writer);
    hangar.print(bufferedWriter);
    bufferedWriter.close();
    String actual = writer.toString();
    checkSameLines(actual, expected);
  }

  private void checkSameLines(String actual, String expected) {
    final String[] actualLines = actual.split("\n");
    final String[] expectedLines = expected.split("\n");
    assertThat(actualLines).containsExactlyInAnyOrder(expectedLines);
  }

}