package com.altaprofits.test.technique.model.building;

import com.altaprofits.test.technique.model.Floating;
import com.altaprofits.test.technique.model.Flying;
import com.altaprofits.test.technique.model.Rolling;
import com.altaprofits.test.technique.model.animal.Animal;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;

public class Farm implements Building {

  private final Set<Animal> animals;

  public Farm() {
    this.animals = new HashSet<>();
  }

  public void add(Animal animal) {
    animals.add(animal);
  }

  @Override
  public Stream<Flying> getFlying() {
    return animals.stream()
        .filter(animal -> animal instanceof Flying)
        .map(animal -> (Flying) animal);
  }

  @Override
  public Stream<Floating> getFloating() {
    return animals.stream()
        .filter(animal -> animal instanceof Floating)
        .map(animal -> (Floating) animal);
  }

  @Override
  public Stream<Rolling> getRolling() {
    return Stream.empty();
  }
}
