package za.ac.cput.myorderapp.Domain;

import org.junit.Assert;
import za.ac.cput.myorderapp.conf.Factory.AddressFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andies on 2015-05-11.
 */
public class TestContactAddress {
   // @Before
    public void setUp() throws Exception {


    }

   // @Test
    public void testCreate() throws Exception {
        Map<String,String>values = new HashMap<String, String>();
        values.put("physicalAddress","18 Harrington street");
        values.put("postalAddress", "P. O . BOX 10");

        ContactAddress contactAddress = AddressFactory.createAddress(values, 8001);
        Assert.assertEquals(8001, contactAddress.getPostalCode());

    }
    //@Test
    public void testUpdate() throws Exception {
        Map<String,String>values = new HashMap<String, String>();
        values.put("physicalAddress","18 Harrington street");
        values.put("postalAddress", "P. O . BOX 10");

        ContactAddress contactAddress = AddressFactory.createAddress(values, 8001);
        ContactAddress newContactAddress = AddressFactory.createAddress(values, 7585);
        Assert.assertEquals(8001, contactAddress.getPostalCode());
        Assert.assertEquals(7585, newContactAddress.getPostalCode());

    }
}
