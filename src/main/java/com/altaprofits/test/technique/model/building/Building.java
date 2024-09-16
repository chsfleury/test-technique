package com.altaprofits.test.technique.model.building;

import com.altaprofits.test.technique.model.Floating;
import com.altaprofits.test.technique.model.Flying;
import com.altaprofits.test.technique.model.Rolling;

import java.util.List;
import java.util.stream.Stream;

public interface Building {

  Stream<Flying> getFlying();
  Stream<Floating> getFloating();
  Stream<Rolling> getRolling();

}
