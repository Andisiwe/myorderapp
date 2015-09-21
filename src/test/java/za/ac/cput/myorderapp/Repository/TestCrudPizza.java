package za.ac.cput.myorderapp.Repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.myorderapp.App;
import za.ac.cput.myorderapp.Domain.Pizza;
import za.ac.cput.myorderapp.Domain.Topping;
import za.ac.cput.myorderapp.conf.Factory.PizzaFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-15.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudPizza extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    private PizzaRepository pizzaRepository;

    @BeforeMethod
    public void setUp() throws Exception {


    }

    @Test
    public void create() throws Exception {
       // List<Topping>toppings = new ArrayList<Topping>();
        Pizza pizza = PizzaFactory.createPizza("Something meaty", 60/*, toppings*/);
        pizzaRepository.save(pizza);
        id = pizza.getPizza_no();
        Assert.assertNotNull(pizza.getPizza_no());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Pizza pizza = pizzaRepository.findOne(id);
        Assert.assertNotNull(pizza.getPizza_no());
        Assert.assertEquals("Something meaty", pizza.getName());

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Pizza pizza = pizzaRepository.findOne(id);
        Pizza newPizza = new Pizza.Builder(pizza.getName())
                                  .copy(pizza)
                                  .price(100)
                                  .build();
        pizzaRepository.save(newPizza);
        Pizza updatedPizza = pizzaRepository.findOne(id);
        Assert.assertEquals(updatedPizza.getPrice(), 100, 2);

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Pizza pizza = pizzaRepository.findOne(id);
        pizzaRepository.delete(pizza);
        Pizza deletedPizza = pizzaRepository.findOne(id);
        Assert.assertNull(deletedPizza);

    }
}
