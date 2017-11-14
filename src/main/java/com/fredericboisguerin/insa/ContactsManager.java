package com.fredericboisguerin.insa;

import java.util.Vector;

public class ContactsManager {

    // ********** ATTRIBUTS **********
    private Vector<Contact> ContactList ;

    // ********** CONSTRUCTEUR **********
    public ContactsManager (){
        this.ContactList = new Vector<Contact>();
    }

    // ********** METHODES **********
    public void addContact(String name, String email, String phoneNumber) {
        ContactList.add(new Contact(name, email, phoneNumber));
    }

    public void printAllContacts() {
        for (Contact contact : ContactList) {
            if (contact.email!=null && contact.phoneNumber!=null)
                System.out.println(contact.name+", "+contact.email+", "+contact.phoneNumber);
            else if (contact.email==null && contact.phoneNumber==null)
                System.out.println(contact.name);
            else if (contact.email==null)
                System.out.println(contact.name+", "+contact.phoneNumber);
            else if (contact.phoneNumber==null)
                System.out.println(contact.name+", "+contact.email);
        }

    }

    public void searchContactByName(String name) {
        for (Contact contact : ContactList) {
            if (contact.name.toLowerCase().contains(name.toLowerCase())){
                if (contact.email!=null && contact.phoneNumber!=null)
                    System.out.println(contact.name+", "+contact.email+", "+contact.phoneNumber);
                else if (contact.email==null && contact.phoneNumber==null)
                    System.out.println(contact.name);
                else if (contact.email==null)
                    System.out.println(contact.name+", "+contact.phoneNumber);
                else if (contact.phoneNumber==null)
                    System.out.println(contact.name+", "+contact.email);
            }
        }
    }

}