package com.fredericboisguerin.insa;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TestGeekUI {

    @Test
    public void test_add_contact() throws InvalidEmailException, InvalidContactNameException, IOException {

        ContactsManager mockCM = Mockito.mock(ContactsManager.class);
        GeekUI myGeekUI = new GeekUI(mockCM);

        String input = "Lolo\nlolo@lolo.lolo\n0102030405";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        myGeekUI.ajouterContact();



        Mockito.verify(mockCM).addContact("Lolo","lolo@lolo.lolo", "0102030405");
    }

}
