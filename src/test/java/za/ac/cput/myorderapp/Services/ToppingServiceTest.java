package za.ac.cput.myorderapp.Services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.myorderapp.Domain.AuditTopping;
import za.ac.cput.myorderapp.Domain.Topping;
import za.ac.cput.myorderapp.Repository.ToppingRepository;
import za.ac.cput.myorderapp.conf.Factory.ToppingFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class ToppingServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ToppingService service;

    private Long id;

    @Autowired
    private ToppingRepository repository;
    private Topping topping;

    //@BeforeMethod
    public void setUp() throws Exception {


    }

   // @Test
    public void create() throws Exception {
        List<AuditTopping> auditToppings = new ArrayList<>();
        Topping topping = ToppingFactory.createTopping("Pine Apple", 5,auditToppings);
        repository.save(topping);
        id = topping.getTop_code();
        Assert.assertNotNull(topping.getTop_code());

    }

    //@Test
    public void testGetToppingInfo() throws Exception {
        List<Topping> topping = service.findAll();
        Assert.assertNotNull(topping);

    }
}
