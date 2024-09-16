package com.altaprofits.test.technique.model.building;

import com.altaprofits.test.technique.model.Floating;
import com.altaprofits.test.technique.model.Flying;
import com.altaprofits.test.technique.model.Rolling;
import com.altaprofits.test.technique.model.vehicle.Vehicle;
import lombok.NonNull;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.altaprofits.test.technique.model.building.HangarSection.AIRPORT;
import static com.altaprofits.test.technique.model.building.HangarSection.GARAGE;
import static com.altaprofits.test.technique.model.building.HangarSection.PORT;

public class Hangar implements Building {

  @NonNull
  private final Set<Vehicle> vehicles;

  public Hangar() {
    vehicles = new HashSet<>();
  }

  public void add(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  public long airportVehicleCount() {
    return vehicles.stream().filter(v -> AIRPORT == v.getSection()).count();
  }

  public long portVehicleCount() {
    return vehicles.stream().filter(v -> PORT == v.getSection()).count();
  }

  public long garageVehicleCount() {
    return vehicles.stream().filter(v -> GARAGE == v.getSection()).count();
  }

  public int totalVehicleCount() {
    return vehicles.size();
  }

  public void printToConsole() throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
      print(writer);
    }
  }

  public void printToFile(Path filePath) throws IOException {
    try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
      print(writer);
    }
  }

  public void print(BufferedWriter writer) throws IOException {
    for (Vehicle vehicle : vehicles) {
      vehicle.print(writer);
      writer.newLine();
    }
  }

  @Override
  public Stream<Flying> getFlying() {
    return vehicles.stream()
        .filter(vehicle -> vehicle instanceof Flying)
        .map(vehicle -> (Flying) vehicle);
  }

  @Override
  public Stream<Floating> getFloating() {
    return vehicles.stream()
        .filter(vehicle -> vehicle instanceof Floating)
        .map(vehicle -> (Floating) vehicle);
  }

  @Override
  public Stream<Rolling> getRolling() {
    return vehicles.stream()
        .filter(vehicle -> vehicle instanceof Rolling)
        .map(vehicle -> (Rolling) vehicle);
  }
}
