package com.company;

class Main {
    public static void main(String [] args){
    ContactsManager myContactsManager = new ContactsManager();
    Contact adam = new Contact();
    adam.name = "Adam";
    adam.phoneNumber = "123456789";
    myContactsManager.addContact(adam);

    Contact adam2 = new Contact();
    adam2.name = "Adam2";
    adam2.phoneNumber = "123456789";
    myContactsManager.addContact(adam2);

    Contact adam3 = new Contact();
    adam3.name = "Adam3";
    adam3.phoneNumber = "123456789";
    myContactsManager.addContact(adam3);

    Contact adam4 = new Contact();
    adam4.name = "Adam4";
    adam4.phoneNumber = "123456789";
    myContactsManager.addContact(adam4);

    Contact result = myContactsManager.searchContact("Adam2");
    System.out.println(result.phoneNumber);
    }
}