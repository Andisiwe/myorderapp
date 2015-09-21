package za.ac.cput.myorderapp.Domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.myorderapp.conf.Factory.ContactsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andies on 2015-05-11.
 */
public class TestCustomerContactsNos {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreate() throws Exception {
        CustomerContactsNos contactsNos = ContactsFactory.createContacts("12345", "67890");
        Assert.assertEquals("12345", contactsNos.getCellNumber());

    }

    @Test
    public void testUpdate() throws Exception {

        CustomerContactsNos contactsNos = ContactsFactory.createContacts("12345", "67890");
        CustomerContactsNos newContactNos = ContactsFactory.createContacts("10111", "67890");
        Assert.assertEquals("12345", contactsNos.getCellNumber());
        Assert.assertEquals("10111", newContactNos.getCellNumber());

    }
}
