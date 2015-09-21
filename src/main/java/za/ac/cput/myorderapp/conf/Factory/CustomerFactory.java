package za.ac.cput.myorderapp.conf.Factory;

import za.ac.cput.myorderapp.Domain.ContactAddress;
import za.ac.cput.myorderapp.Domain.Customer;
import za.ac.cput.myorderapp.Domain.CustomerContactsNos;
import za.ac.cput.myorderapp.Domain.Orders;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/25.
 */
public class CustomerFactory {
    public static Customer createCustomer(Map<String, String> values, String username, String password, ContactAddress address,
                                          CustomerContactsNos contactsNos, List<Orders> order){
        Customer customer = new Customer.Builder(values.get("name"))
                .surname(values.get("surname"))
                .username(username)
                .password(password)
                .address(address)
                .contactNos(contactsNos)
                .order(order)
                .build();

        return customer;
    }
}
