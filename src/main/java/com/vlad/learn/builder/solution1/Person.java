package com.vlad.learn.builder.solution1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final Long creditCardNumber;
    private final Long geoLocationX;
    private final Long geoLocationY;
}
