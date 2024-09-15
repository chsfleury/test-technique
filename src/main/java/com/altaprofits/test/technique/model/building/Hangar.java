package com.altaprofits.test.technique.model.building;

import com.altaprofits.test.technique.model.FloatingVehicle;
import com.altaprofits.test.technique.model.FlyingVehicle;
import com.altaprofits.test.technique.model.RollingVehicle;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Hangar {

  @NonNull
  private final Set<FlyingVehicle> flyingVehicles;

  @NonNull
  private final Set<FloatingVehicle> floatingVehicles;

  @NonNull
  private final Set<RollingVehicle> rollingVehicles;

  public Hangar() {
    floatingVehicles = new HashSet<>();
    flyingVehicles = new HashSet<>();
    rollingVehicles = new HashSet<>();
  }

  public void add(FlyingVehicle vehicle) {
    flyingVehicles.add(vehicle);
  }

  public void add(FloatingVehicle vehicle) {
    floatingVehicles.add(vehicle);
  }

  public void add(RollingVehicle vehicle) {
    rollingVehicles.add(vehicle);
  }

  public int flyingVehicleCount() {
    return flyingVehicles.size();
  }

  public int floatingVehicleCount() {
    return floatingVehicles.size();
  }

  public int rollingVehicleCount() {
    return rollingVehicles.size();
  }

  public int totalVehicleCount() {
    return flyingVehicleCount() + floatingVehicleCount() + rollingVehicleCount();
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
    for (FlyingVehicle vehicle : flyingVehicles) {
      vehicle.print(writer);
      writer.newLine();
    }

    for (FloatingVehicle vehicle : floatingVehicles) {
      vehicle.print(writer);
      writer.newLine();
    }

    for (RollingVehicle vehicle : rollingVehicles) {
      vehicle.print(writer);
      writer.newLine();
    }
  }

}
