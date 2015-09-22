package za.ac.cput.myorderapp.Domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.myorderapp.conf.Factory.BaseFactory;
import za.ac.cput.myorderapp.conf.Factory.PizzaFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-14.
 */
public class TestBase {
   // @Before
    public void setUp() throws Exception {


    }

    //@Test
    public void testCreateBase() throws Exception {
       // Pizza pizza = PizzaFactory.createPizza("Something meaty", 60);
        List<Pizza> pizzas = new ArrayList<>();
        Base base = BaseFactory.createBase("Large", 60, pizzas);

        Assert.assertEquals("Large", base.getPizzaSize());

    }
}
