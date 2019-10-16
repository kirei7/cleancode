package com.vlad.learn.builder.solution2;

import jdk.internal.joptsimple.internal.Strings;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Person {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final Long creditCardNumber;
    private final Long geoLocationX;
    private final Long geoLocationY;

    public Person(String firstName, String lastName, String email, String address, Long creditCardNumber, Long geoLocationX, Long geoLocationY) {
        //preparing the defaults
        if (Strings.isNullOrEmpty(firstName)) {
            firstName = "John";
        }
        if (Strings.isNullOrEmpty(lastName)) {
            lastName = "Doe";
        }
        if (Strings.isNullOrEmpty(email)) {
            email = "example@internal.com";
        }
        if (Strings.isNullOrEmpty(address)) {
            address = "Diagon Alley";
        }
        if (creditCardNumber == null) {
            creditCardNumber = 9999999999999999L; //dummy card
        }
        //setting the values
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.geoLocationX = geoLocationX;
        this.geoLocationY = geoLocationY;
    }

}
