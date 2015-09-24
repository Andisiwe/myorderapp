package za.ac.cput.myorderapp.Repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.myorderapp.Domain.ContactAddress;
import za.ac.cput.myorderapp.Domain.Customer;
import za.ac.cput.myorderapp.Domain.CustomerContactsNos;
import za.ac.cput.myorderapp.Domain.Orders;
import za.ac.cput.myorderapp.conf.Factory.AddressFactory;
import za.ac.cput.myorderapp.conf.Factory.ContactsFactory;
import za.ac.cput.myorderapp.conf.Factory.CustomerFactory;

import java.util.*;

/**
 * Created by student on 2015/05/03.
 */

//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestCrudCustomer extends AbstractTestNGSpringContextTests {
    private Long id;

   @Autowired
    CustomerRepository customerRepository;

    //@BeforeMethod
    public void setUp() throws Exception {


    }

   // @Test
    public void testCreate() throws Exception {
        Map<String, String> custDetails = new HashMap<String, String>();
        custDetails.put("name", "Andisiwe");
        custDetails.put("surname", "Peter");

        Map<String,String>address = new HashMap<String,String>();
        address.put("physicalAddress", "18 Harrington street");
        address.put("postalAddress", "P. O. BOX 10");

        Map<String,String>loginDetails = new HashMap<String,String>();
        loginDetails.put("username", "andisiwe");
        loginDetails.put("password", "peter");


        Date date = new Date();

        ContactAddress contactAddress = AddressFactory.createAddress(address, 8001);
        CustomerContactsNos contactsNos = ContactsFactory.createContacts("082123", "021123");
       // Orders orders = OrderFactory.createOrder("10-MAY-15");
        List<Orders> order = new ArrayList<>();
        Customer customer = CustomerFactory.createCustomer(custDetails,loginDetails, contactAddress, contactsNos,order);

        customerRepository.save(customer);
        id = customer.getId();
        Assert.assertNotNull(customer.getId());

    }

   // @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Customer customer = customerRepository.findOne(id);
        Assert.assertEquals("Andisiwe", customer.getName());

    }

    //@Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Customer customer = customerRepository.findOne(id);

        Map<String, String> custDetails = new HashMap<String, String>();
        custDetails.put("name", "Yamkela");
        custDetails.put("surname", "Peter");

        Map<String,String>address = new HashMap<String,String>();
        address.put("physicalAddress", "18 Harrington street");
        address.put("postalAddress", "P. O. BOX 10");

        Map<String,String>loginDetails = new HashMap<String,String>();
        loginDetails.put("username", "andisiwe");
        loginDetails.put("password", "peter");

        Date date = new Date();

        ContactAddress contactAddress = AddressFactory.createAddress(address, 8001);
        CustomerContactsNos contactsNos = ContactsFactory.createContacts("082123", "021123");
        //Order order = OrderFactory.createOrder(date);*/
        List<Orders> order = new ArrayList<>();
        Customer newCustomer = CustomerFactory.createCustomer(custDetails,loginDetails, contactAddress, contactsNos,order);

        customerRepository.save(newCustomer);
        Assert.assertEquals("Yamkela", newCustomer.getName());

    }

   // @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Customer customer = customerRepository.findOne(id);
        customerRepository.delete(customer);
        Customer deletedCustomer = customerRepository.findOne(id);
        Assert.assertNull(deletedCustomer);

    }


}
