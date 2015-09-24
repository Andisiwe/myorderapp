package za.ac.cput.myorderapp.Domain;

import org.junit.Assert;
import za.ac.cput.myorderapp.conf.Factory.AddressFactory;
import za.ac.cput.myorderapp.conf.Factory.ContactsFactory;
import za.ac.cput.myorderapp.conf.Factory.CustomerFactory;

import java.util.*;

/**
 * Created by student on 2015/04/23.
 */
public class TestCustomer {

    //@Before
    public void setUp() throws Exception {


    }

   // @Test
    public void testCreateCustomer() throws Exception {
        Map<String, String>addr = new HashMap<String, String>();
        addr.put("physicalAddress", "18 Harrington street");
        addr.put("postalAddress", "P. O. BOX 10");

        Map<String, String>custDetails = new HashMap<String, String>();
        custDetails.put("name","Andisiwe");
        custDetails.put("surname", "Peter");

        Date date = new Date();

        ContactAddress address = AddressFactory.createAddress(addr, 8001);
        CustomerContactsNos contactsNos = ContactsFactory.createContacts("12345", "67890");

        Map<String,String>loginDetails = new HashMap<String,String>();
        loginDetails.put("username", "andisiwe");
        loginDetails.put("password", "peter");
       // Order order = OrderFactory.createOrder(date);*/
        List<Orders> ordersList = new ArrayList<>();

        Customer customer = CustomerFactory.createCustomer(custDetails, loginDetails, address, contactsNos, ordersList);// address, contactsNos,order);
        Assert.assertEquals("Andisiwe", customer.getName());

    }

    //@Test
    public void testUpdatedCustomer() throws Exception {
        Map<String, String>addr = new HashMap<String, String>();
        addr.put("physicalAddress", "18 Harrington street");
        addr.put("postalAddress", "P. O. BOX 10");

        Map<String, String>custDetails = new HashMap<String, String>();
        custDetails.put("name","Andisiwe");
        custDetails.put("surname", "Peter");

        Map<String,String>loginDetails = new HashMap<String,String>();
        loginDetails.put("username", "andisiwe");
        loginDetails.put("password", "peter");

        Date date = new Date();
        System.out.println(date);

        ContactAddress address = AddressFactory.createAddress(addr, 8001);
        CustomerContactsNos contactsNos = ContactsFactory.createContacts("12345", "67890");
       // Orders order = OrderFactory.createOrder(date);
        List<Orders> ordersList = new ArrayList<>();

        Customer customer = CustomerFactory.createCustomer(custDetails,loginDetails, address, contactsNos, ordersList);// address, contactsNos,order);

        Customer newCustomer = new Customer.Builder("Andisiwe")
                                            .copy(customer)
                                            .surname("Paul")
                                            .build();

        Assert.assertEquals("Paul", newCustomer.getSurname());
        Assert.assertEquals("Peter", customer.getSurname());

    }
}
