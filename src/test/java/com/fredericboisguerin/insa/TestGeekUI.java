package com.fredericboisguerin.insa;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class TestGeekUI {

    @Test
    public void test_menu() throws IOException {
        ContactsManager mockCM = Mockito.mock(ContactsManager.class);
        GeekUI myGeekUI = new GeekUI();
        myGeekUI.displayMenu();
        Mockito.verify(mockCM).printAllContacts();
    }

}
