package za.ac.cput.myorderapp.Domain;

import org.junit.Assert;
import za.ac.cput.myorderapp.conf.Factory.PizzaFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-14.
 */
public class TestPizza {
    //@Before
    public void setUp() throws Exception {


    }

   // @Test
    public void testCreatePizza() throws Exception {
        List<Topping>toppings = new ArrayList<>();
        Pizza pizza = PizzaFactory.createPizza("Something meaty", 60/*, toppings*/);

        Assert.assertEquals("Something meaty", pizza.getName());

    }
}
