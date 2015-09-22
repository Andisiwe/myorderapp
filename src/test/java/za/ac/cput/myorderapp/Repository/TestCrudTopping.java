package za.ac.cput.myorderapp.Repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.myorderapp.App;
import za.ac.cput.myorderapp.Domain.AuditTopping;
import za.ac.cput.myorderapp.Domain.Topping;
import za.ac.cput.myorderapp.conf.Factory.ToppingFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-19.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestCrudTopping extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private ToppingRepository repository;

    //@BeforeMethod
    public void setUp() throws Exception {


    }

    //@Test
    public void create() throws Exception {
        List<AuditTopping> auditToppings = new ArrayList<>();
        Topping topping = ToppingFactory.createTopping("Pine Apple",5, auditToppings);
        repository.save(topping);
        id = topping.getTop_code();
        Assert.assertNotNull(topping.getTop_code());

    }

  //  @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Topping topping = repository.findOne(id);
        Assert.assertNotNull(topping.getTop_code());
    }

    //@Test(dependsOnMethods = "read")
    public void delete() throws Exception {
        Topping topping = repository.findOne(id);
        repository.delete(topping);
        Topping deletedTopping = repository.findOne(id);
        Assert.assertNull(deletedTopping);

    }
}
