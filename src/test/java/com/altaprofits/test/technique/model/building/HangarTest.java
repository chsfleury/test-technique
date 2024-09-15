package com.altaprofits.test.technique.model.building;

import com.altaprofits.test.technique.model.vehicle.AirPlane;
import com.altaprofits.test.technique.model.vehicle.Boat;
import com.altaprofits.test.technique.model.vehicle.Car;
import com.altaprofits.test.technique.model.vehicle.Motorcycle;
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
    assertThat(hangar.floatingVehicleCount()).isEqualTo(0);
    assertThat(hangar.flyingVehicleCount()).isEqualTo(0);
    assertThat(hangar.rollingVehicleCount()).isEqualTo(0);
    assertThat(hangar.totalVehicleCount()).isEqualTo(0);
    checkPrint("", hangar);
  }

  @Test
  public void testFullHangar() throws IOException {
    Hangar hangar = new Hangar();
    hangar.add(new Car(1, "Peugeot"));
    hangar.add(new Boat(2, "Voilier"));
    hangar.add(new AirPlane(3, "Spitfire"));
    assertThat(hangar.floatingVehicleCount()).isEqualTo(1);
    assertThat(hangar.flyingVehicleCount()).isEqualTo(1);
    assertThat(hangar.rollingVehicleCount()).isEqualTo(1);
    assertThat(hangar.totalVehicleCount()).isEqualTo(3);
    checkPrint(
        """
            AirPlane (id=3, name=Spitfire)
            Boat (id=2, name=Voilier)
            Car (id=1, name=Peugeot)
            """.stripIndent(),
        hangar
    );
  }

  @Test
  public void testPrintToFile() throws IOException {
    Path testFile = Files.createTempFile("testHangar", "");
    Hangar hangar = new Hangar();
    hangar.add(new Car(1, "Peugeot"));
    hangar.add(new Boat(2, "Voilier"));
    hangar.add(new AirPlane(3, "Spitfire"));
    hangar.printToFile(testFile);

    String actual = Files.readString(testFile);
    assertThat(actual).isEqualTo(
        """
            AirPlane (id=3, name=Spitfire)
            Boat (id=2, name=Voilier)
            Car (id=1, name=Peugeot)
            """.stripIndent()
    );
  }

  private void checkPrint(String expected, Hangar hangar) throws IOException {
    StringWriter writer = new StringWriter();
    BufferedWriter bufferedWriter = new BufferedWriter(writer);
    hangar.print(bufferedWriter);
    bufferedWriter.close();
    String actual = writer.toString();
    assertThat(actual).isEqualTo(expected);
  }

}