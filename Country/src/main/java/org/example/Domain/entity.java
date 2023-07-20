package org.example.Domain;


import javax.persistence.*;

@Entity
@Table(name="countries")

public class entity {

    @Id
    @GeneratedValue
    @Column(name="countryCode")
    private String countryCode;

    @Column(name="countryName")
    private String countryName;

    public entity(){

    }

    public entity(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
