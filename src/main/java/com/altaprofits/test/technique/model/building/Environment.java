package com.altaprofits.test.technique.model.building;

import com.altaprofits.test.technique.model.Floating;
import com.altaprofits.test.technique.model.Flying;
import com.altaprofits.test.technique.model.Rolling;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public class Environment {

  private final Hangar hangar;
  private final Farm farm;


  public List<Flying> getFlying() {
    return Stream.concat(
        hangar.getFlying(),
        farm.getFlying()
    ).toList();
  }

  public List<Floating> getFloating() {
    return Stream.concat(
        hangar.getFloating(),
        farm.getFloating()
    ).toList();
  }

  public List<Rolling> getRolling() {
    return Stream.concat(
        hangar.getRolling(),
        farm.getRolling()
    ).toList();
  }
}
