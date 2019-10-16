package com.vlad.learn.builder.solution2;

import com.vlad.learn.builder.GeoLocationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProblemSolvedInside {

    private GeoLocationService geoLocationService;

    public void letsCreatePerson(String firstName,
                                 String lastName,
                                 String email,
                                 String address,
                                 Long creditCardNumber,
                                 Long geoLocationX,
                                 Long geoLocationY) {
        Person person = new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
    }

    public void whatIfSomeParametersAreNull(String firstName,
                                            String lastName,
                                            String email,
                                            String address,
                                            Long creditCardNumber,
                                            Long geoLocationX,
                                            Long geoLocationY) {
        if (geoLocationX == null) {
            geoLocationX = geoLocationService.calculateLocationX();
        }
        if (geoLocationY == null) {
            geoLocationY = geoLocationService.calculateLocationY();
        }
        Person person = new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
    }

    public void whatIfMoreParametersAreNull(String firstName,
                                            String lastName,
                                            String email,
                                            String address,
                                            Long creditCardNumber,
                                            Long geoLocationX,
                                            Long geoLocationY) {
        if (geoLocationX == null) {
            geoLocationX = geoLocationService.calculateLocationX();
        }
        if (geoLocationY == null) {
            geoLocationY = geoLocationService.calculateLocationY();
        }
        Person person = new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
    }

    public void whatIfMoreParametersAreNullButInOtherFlow(String firstName,
                                                          String lastName,
                                                          String email,
                                                          String address,
                                                          Long creditCardNumber,
                                                          Long geoLocationX,
                                                          Long geoLocationY) {
        if (geoLocationX == null) {
            geoLocationX = geoLocationService.calculateLocationX();
        }
        if (geoLocationY == null) {
            geoLocationY = geoLocationService.calculateLocationY();
        }
        Person person = new Person(firstName, lastName, email, address, creditCardNumber, geoLocationX, geoLocationY);
    }

    //and here we know that we miss some values beforehand
    public void whatIfWeWantADefaultsForSure(String firstName,
                                             String lastName,
                                             String email) {
        Person person = new Person(firstName, lastName, email, null, null, geoLocationService.calculateLocationX(), geoLocationService.calculateLocationY());
    }

}
