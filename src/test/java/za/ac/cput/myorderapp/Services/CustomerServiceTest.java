package za.ac.cput.myorderapp.Services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.myorderapp.Domain.ContactAddress;
import za.ac.cput.myorderapp.Domain.Customer;
import za.ac.cput.myorderapp.Domain.CustomerContactsNos;
import za.ac.cput.myorderapp.Domain.Orders;
import za.ac.cput.myorderapp.Repository.CustomerRepository;
import za.ac.cput.myorderapp.conf.Factory.AddressFactory;
import za.ac.cput.myorderapp.conf.Factory.ContactsFactory;
import za.ac.cput.myorderapp.conf.Factory.CustomerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andies on 2015-05-20.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private CustomerService service;

    private Long id;

    @Autowired
    private CustomerRepository repository;
    private Customer customer;

    //@BeforeMethod
    public void setUp() throws Exception {


    }

   // @Test
    public void create() throws Exception {
        Map<String, String> values = new HashMap<String, String>();
        values.put("name", "Andisiwe");
        values.put("surname", "Peter");

        Map<String,String>address = new HashMap<String,String>();
        address.put("physicalAddress", "18 Harrington street");
        address.put("postalAddress", "P. O. BOX 10");

        ContactAddress contactAddress = AddressFactory.createAddress(address, 8001);
        CustomerContactsNos contactsNos = ContactsFactory.createContacts("082123", "021123");

        Map<String,String>loginDetails = new HashMap<String,String>();
        address.put("username", "andisiwe");
        address.put("password", "peter");

        List<Orders> order = new ArrayList<>();
        Customer customer = CustomerFactory.createCustomer(values,loginDetails,contactAddress, contactsNos,order);
        repository.save(customer);
        id = customer.getId();
        Assert.assertNotNull(customer.getId());

    }

   // @Test
    public void testGetCustomerInfo() throws Exception {
        List<Customer> customer = service.findAll();
        Assert.assertNotNull(customer);

    }
}
