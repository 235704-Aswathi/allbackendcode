package org.example;

public class ProductionCompanies {

    private int id;
    private String name;
    private String originCountry;
    private String logoPath;

    public ProductionCompanies(int id, String name, String originCountry, String logoPath) {
        this.id = id;
        this.name = name;
        this.originCountry = originCountry;
        this.logoPath = logoPath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
}
