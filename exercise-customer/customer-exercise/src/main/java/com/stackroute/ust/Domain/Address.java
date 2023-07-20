package com.stackroute.ust.Domain;


import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String Street;
    private String city;
    private String state;
    private String country;

}
