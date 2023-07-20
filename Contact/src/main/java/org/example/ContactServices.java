package org.example;

public interface ContactServices  {

    void addContact(Contact contact);
    void deleteContact(String firstName, String lastName);
    void updateContact(Contact contact);
    Contact searchContact(String firstName, String lastName);
    void displayContact(SortOption sortOption);
    void print();

}
