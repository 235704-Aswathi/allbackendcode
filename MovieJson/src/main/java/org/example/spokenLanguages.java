package org.example;

public class spokenLanguages {

    public spokenLanguages(String iso_639_1, String name) {
        this.iso_639_1 = iso_639_1;
        this.name = name;
    }

    private String iso_639_1;
    private String name;

    public String getIso_639_1() {
        return iso_639_1;
    }

    public String getName() {
        return name;
    }

}
