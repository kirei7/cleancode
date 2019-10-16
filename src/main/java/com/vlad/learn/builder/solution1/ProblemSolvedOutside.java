package com.vlad.learn.builder.solution1;

import com.vlad.learn.builder.GeoLocationService;
import jdk.internal.joptsimple.internal.Strings;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProblemSolvedOutside {

    private GeoLocationService geoLocationService;

    public void letsCreatePerson(String firstName,
                                 String lastName,
                                 String email,
                                 String address,
                                 Long creditCardNumber,
                                 Long geoLocationX,
                                 Long geoLocationY) {
        Person person = new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
        //wow nice, no problems so far
    }

    public void whatIfSomeParametersAreNull(String firstName,
                                            String lastName,
                                            String email,
                                            String address,
                                            Long creditCardNumber,
                                            Long geoLocationX,
                                            Long geoLocationY) {
        //ok, a bit of preventive measures
        if (Strings.isNullOrEmpty(firstName)) {
            firstName = "John";
        }
        if (Strings.isNullOrEmpty(lastName)) {
            lastName = "Doe";
        }
        Person person = new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
        //tough but fair
    }

    public void whatIfMoreParametersAreNull(String firstName,
                                            String lastName,
                                            String email,
                                            String address,
                                            Long creditCardNumber,
                                            Long geoLocationX,
                                            Long geoLocationY) {
        //ok, a bit of preventive measures
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

        Person person = new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
        //pain in the butt
    }

    public void whatIfMoreParametersAreNullButInOtherFlow(String firstName,
                                                          String lastName,
                                                          String email,
                                                          String address,
                                                          Long creditCardNumber,
                                                          Long geoLocationX,
                                                          Long geoLocationY) {
        //not again
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

        Person person = new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
        // x_x
    }

    //and here we know that we miss some values beforehand
    public void whatIfWeWantADefaultsForSure(String firstName,
                                             String lastName,
                                             String email) {
        //enough
        if (Strings.isNullOrEmpty(firstName)) {
            firstName = "John";
        }
        if (Strings.isNullOrEmpty(lastName)) {
            lastName = "Doe";
        }
        //populate with the defaults
        String address = "Diagon Alley";
        Long creditCardNumber = 9999999999999999L;
        Long geoLocationX = geoLocationService.calculateLocationX();
        Long geoLocationY = geoLocationService.calculateLocationY();

        Person person = new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
    }

    //BTW, I've missed the email check, now consider fixing this and adding it to all flows
}
