package com.altaprofits.test.technique.model.utils;

import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UID {

  public static String generate() {
    return UUID.randomUUID().toString();
  }

}
