package za.ac.cput.myorderapp.Services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.myorderapp.Domain.Pizza;
import za.ac.cput.myorderapp.Domain.Topping;
import za.ac.cput.myorderapp.Repository.PizzaRepository;
import za.ac.cput.myorderapp.conf.Factory.PizzaFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestPizzaService extends AbstractTestNGSpringContextTests {
    @Autowired
    private PizzaService service;

    private Long id;

    @Autowired
    private PizzaRepository repository;
    private Pizza pizza;

    //@BeforeMethod
    public void setUp() throws Exception {


    }

    //@Test
    public void create() throws Exception {
        List<Topping> toppings = new ArrayList<>();
        Pizza pizza = PizzaFactory.createPizza("Something meaty", 60/*, toppings*/);
        repository.save(pizza);
        id = pizza.getPizza_no();
        Assert.assertNotNull(pizza.getPizza_no());

    }

    //@Test
    public void testGetPizzaInfo() throws Exception {
        List<Pizza> pizza = service.findAll();
        Assert.assertNotNull(pizza);

    }
}
