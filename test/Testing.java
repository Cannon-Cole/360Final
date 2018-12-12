/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.AddPerson;
import Controller.DisplayAll;
import Controller.MainControl;
import Controller.StoreJSON;
import Model.PassAround;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cole
 */
public class Testing {

    @Test
    public void AllTests() {
        //Checks to make sure the database query works
        DisplayAll displayPeople = new DisplayAll();
        displayPeople.handleIt();
        //Checks to make sure select query came through and the output was formatted
        assertTrue(PassAround.table.length() > 0);
        //Checks to make sure program is waiting for thread
        assertNotNull(PassAround.latchDisplay);

        //Checks to make sure JSON export works
        StoreJSON JSON = new StoreJSON();
        JSON.handleIt();
        //Checks to make sure the database exported
        assertSame(PassAround.message, "Database exported to JSON");
        //Checks to make sure program is waiting for thread
        assertNotNull(PassAround.latchJSON);
        
        //Checks to make sure Add person export works
        AddPerson addPerson = new AddPerson();
        addPerson.handleIt();
         //Checks to make sure that the database successfully added a new person
        assertSame(PassAround.message, "Person Added");
        //Checks to make sure program is waiting for thread
        assertNotNull(PassAround.latchAdd);
        Object MainControl;
        
        //Checks to make sure servlet started
        MainControl main = new MainControl();
        String message = main.getServletInfo();
        assertSame(message, "This servlet handles the actions of a basic web app managing people");
    }
}
