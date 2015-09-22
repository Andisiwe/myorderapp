package za.ac.cput.myorderapp.Domain;

import org.junit.Before;
import org.junit.Test;
import za.ac.cput.myorderapp.conf.Factory.ToppingFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-14.
 */
public class TestTopping {
   // @Before
    public void setUp() throws Exception {


    }

    //@Test
    public void testCreateTopping() throws Exception {
        List<AuditTopping> auditToppings = new ArrayList<>();
        Topping topping = ToppingFactory.createTopping("Pine Apple", 5,auditToppings);

    }
}
