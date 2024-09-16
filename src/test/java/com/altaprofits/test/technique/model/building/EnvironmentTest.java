package com.altaprofits.test.technique.model.building;

import com.altaprofits.test.technique.model.animal.Chicken;
import com.altaprofits.test.technique.model.animal.Frog;
import com.altaprofits.test.technique.model.animal.Swan;
import com.altaprofits.test.technique.model.vehicle.AirPlane;
import com.altaprofits.test.technique.model.vehicle.Boat;
import com.altaprofits.test.technique.model.vehicle.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnvironmentTest {

  @Test
  public void testEmptyEnvironment() {
    // Given
    Hangar hangar = new Hangar();
    Farm farm = new Farm();
    Environment environment = new Environment(hangar, farm);
    assertThat(environment.getFlying()).isEmpty();
    assertThat(environment.getFloating()).isEmpty();
    assertThat(environment.getRolling()).isEmpty();
  }

  @Test
  public void testPopulatedEnvironment() {
    Hangar hangar = new Hangar();

    Car car = new Car("Peugeot");
    hangar.add(car);

    Boat boat = new Boat("Voilier");
    hangar.add(boat);

    AirPlane airplane = new AirPlane("Spitfire");
    hangar.add(airplane);

    Farm farm = new Farm();

    Chicken chicken = new Chicken("Cocotte");
    farm.add(chicken);

    Frog frog = new Frog("Smacks");
    farm.add(frog);

    Swan swan = new Swan("Blake");
    farm.add(swan);

    Environment environment = new Environment(hangar, farm);

    assertThat(environment.getFlying())
        .containsExactlyInAnyOrder(
            airplane,
            chicken,
            swan
        );

    assertThat(environment.getFloating())
        .containsExactlyInAnyOrder(
            boat,
            frog,
            swan
        );

    assertThat(environment.getRolling())
        .containsExactlyInAnyOrder(
            car
        );
  }

}