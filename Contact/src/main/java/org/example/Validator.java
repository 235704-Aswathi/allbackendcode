package org.example;

public class Validator {

    private static final String NAME_REGEX = "[a-zA-Z]+";
    private static final String PHONE_NUMBER_REGEX = "[\\d{10}]+";

    private Validator() {


    }

    public static boolean isValidName(String firstName, String lastName) {
        return firstName != null || lastName != null || (firstName.matches(NAME_REGEX) || lastName.matches(NAME_REGEX));
    }
    public static boolean isNumberValid(String phoneNumber) {

        return phoneNumber!=null || phoneNumber.matches(PHONE_NUMBER_REGEX);
    }
}



