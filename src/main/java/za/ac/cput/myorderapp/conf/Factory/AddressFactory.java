package za.ac.cput.myorderapp.conf.Factory;

import za.ac.cput.myorderapp.Domain.ContactAddress;

import java.util.Map;

/**
 * Created by Andies on 2015-05-11.
 */
public class AddressFactory {
    public static ContactAddress createAddress(Map<String,String>values, int postalCode){
        ContactAddress contactAddress = new ContactAddress.Builder(values.get("physicalAddress"))
                                        .postalAddress(values.get("postalAddress"))
                                        .postalCode(postalCode)
                                        .build();
        return contactAddress;
    }
}
