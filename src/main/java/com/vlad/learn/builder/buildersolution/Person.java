package com.vlad.learn.builder.buildersolution;

import com.vlad.learn.builder.GeoLocationService;
import jdk.internal.joptsimple.internal.Strings;
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

    private Person(String firstName, String lastName, String email, String address, Long creditCardNumber, Long geoLocationX, Long geoLocationY) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.geoLocationX = geoLocationX;
        this.geoLocationY = geoLocationY;
    }

    public static PersonBuilder builder(GeoLocationService geoLocationService) {
        return new PersonBuilder(geoLocationService);
    }

    public static class PersonBuilder {
        private GeoLocationService geoLocationService;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private Long creditCardNumber;
        private Long geoLocationX;
        private Long geoLocationY;

        public Person build() {
            if (Strings.isNullOrEmpty(firstName)) {
                firstName = "John";
            }
            if (Strings.isNullOrEmpty(lastName)) {
                lastName = "Doe";
            }
            if (Strings.isNullOrEmpty(address)) {
                address = "Diagon Alley";
            }
            if (creditCardNumber == null) {
                creditCardNumber = 9999999999999999L; //dummy card
            }
            if (geoLocationX == null) {
                geoLocationX = geoLocationService.calculateLocationX();
            }
            if (geoLocationY == null) {
                geoLocationY = geoLocationService.calculateLocationY();
            }
            return new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
        }

        private PersonBuilder(GeoLocationService geoLocationService) {
            this.geoLocationService = geoLocationService;
        }

        public PersonBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder withCreditCardNumber(Long creditCardNumber) {
            this.creditCardNumber = creditCardNumber;
            return this;
        }

        public PersonBuilder withGeoLocationX(Long geoLocationX) {
            this.geoLocationX = geoLocationX;
            return this;
        }

        public PersonBuilder withGeoLocationY(Long geoLocationY) {
            this.geoLocationY = geoLocationY;
            return this;
        }
    }
}
