package com.vlad.learn.builder.buildersolution;


import com.vlad.learn.builder.GeoLocationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProblemSolvedWithBuilder {

    private GeoLocationService geoLocationService;

    public void letsCreatePerson(String firstName,
                                 String lastName,
                                 String email,
                                 String address,
                                 Long creditCardNumber,
                                 Long geoLocationX,
                                 Long geoLocationY) {
        Person person = Person.builder(geoLocationService)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withAddress(address)
                .withEmail(email)
                .withCreditCardNumber(creditCardNumber)
                .withGeoLocationX(geoLocationX)
                .withGeoLocationY(geoLocationY)
                .build();
    }

    public void whatIfSomeParametersAreNull(String firstName,
                                            String lastName,
                                            String email,
                                            String address,
                                            Long creditCardNumber,
                                            Long geoLocationX,
                                            Long geoLocationY) {
        Person person = Person.builder(geoLocationService)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withAddress(address)
                .withEmail(email)
                .withCreditCardNumber(creditCardNumber)
                .withGeoLocationX(geoLocationX)
                .withGeoLocationY(geoLocationY)
                .build();
    }

    public void whatIfMoreParametersAreNull(String firstName,
                                            String lastName,
                                            String email,
                                            String address,
                                            Long creditCardNumber,
                                            Long geoLocationX,
                                            Long geoLocationY) {
        Person person = Person.builder(geoLocationService)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withAddress(address)
                .withEmail(email)
                .withCreditCardNumber(creditCardNumber)
                .withGeoLocationX(geoLocationX)
                .withGeoLocationY(geoLocationY)
                .build();
    }

    public void whatIfMoreParametersAreNullButInOtherFlow(String firstName,
                                                          String lastName,
                                                          String email,
                                                          String address,
                                                          Long creditCardNumber,
                                                          Long geoLocationX,
                                                          Long geoLocationY) {
        Person person = Person.builder(geoLocationService)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withAddress(address)
                .withEmail(email)
                .withCreditCardNumber(creditCardNumber)
                .withGeoLocationX(geoLocationX)
                .withGeoLocationY(geoLocationY)
                .build();
    }

    //and here we know that we miss some values beforehand
    public void whatIfWeWantADefaultsForSure(String firstName,
                                             String lastName,
                                             String email) {
        Person person = Person.builder(geoLocationService)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEmail(email)
                .build();
    }

}
