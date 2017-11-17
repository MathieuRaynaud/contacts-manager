package com.fredericboisguerin.insa;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.Vector;



public class ContactsManager {

    // ********** ATTRIBUTS **********
    private Vector<Contact> ContactList ;


    // ********** CONSTRUCTEUR **********
    public ContactsManager () throws IOException{
        try {
            this.ContactList = new Vector<Contact>();
            CSVReader reader = new CSVReader(new FileReader("contacts.csv"));
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                this.ContactList.add(new Contact(nextLine[0], nextLine[1], nextLine[2]));
            }
        } catch (FileNotFoundException e) {}
    }


    // ********** METHODES **********
    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException, InvalidEmailException, IOException {

        Writer writer = new FileWriter("contacts.csv", true);

        if (name==null) throw new InvalidContactNameException();
        else if (name.equals("")) throw new InvalidContactNameException();
        else if (!(email.contains("@"))) throw new InvalidEmailException();
        else {
            ContactList.add(new Contact(name, email, phoneNumber));
            String tmp = name+','+email+','+phoneNumber+"\n";
            writer.append(tmp);
        }

        writer.close();

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



    /*

    // List<MyBean> beans comes from somewhere earlier in your code.
     Writer writer = new FileWriter("yourfile.csv");
     StatefulBeanToCsvBuilder beanToCsv = StatefulBeanToCsvBuilder(writer).build();
     beanToCsv.write(beans);
     writer.close();

     */

}