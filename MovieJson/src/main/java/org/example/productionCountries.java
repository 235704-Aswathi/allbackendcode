package org.example;

public class productionCountries {


    private String name;
    private String iso_3166_1;

    public productionCountries(String name, String iso_3166_1) {
        this.name = name;
        this.iso_3166_1 = iso_3166_1;
    }

    public String getName() {
        return name;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }
}
