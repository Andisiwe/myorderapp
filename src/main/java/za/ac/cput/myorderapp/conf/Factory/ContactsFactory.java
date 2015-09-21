package za.ac.cput.myorderapp.conf.Factory;

import za.ac.cput.myorderapp.Domain.CustomerContactsNos;


/**
 * Created by Andies on 2015-05-ts11.
 */
public class ContactsFactory {
    public static CustomerContactsNos createContacts(String cellNumber, String phoneNumber){
        CustomerContactsNos contactsNos = new CustomerContactsNos.Builder(cellNumber)
                                                                .homeNumber(phoneNumber)
                                                                .build();
        return contactsNos;
    }
}
