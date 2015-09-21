package za.ac.cput.myorderapp.Repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.myorderapp.App;
import za.ac.cput.myorderapp.Domain.Base;
import za.ac.cput.myorderapp.Domain.Pizza;
import za.ac.cput.myorderapp.conf.Factory.BaseFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-19.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudBase extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private BaseRepository repository;

    @Test
    public void create() throws Exception {
        List<Pizza>pizzas = new ArrayList<>();
        Base base = BaseFactory.createBase("Large", 60, pizzas);
        repository.save(base);
        id = base.getBaseCode();
        Assert.assertNotNull(base.getBaseCode());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Base base = repository.findOne(id);
        Assert.assertNotNull(base.getBaseCode());
        Assert.assertEquals("Large", base.getPizzaSize());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Base base = repository.findOne(id);
        Base newBase = new Base.Builder(base.getPizzaSize())
                                .copy(base)
                                .price(65)
                                .build();
        repository.save(newBase);
        Base updatedBase = repository.findOne(id);
        Assert.assertEquals(65, updatedBase.getPrice(), 2);

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Base base = repository.findOne(id);
        repository.delete(base);
        Base deletedBase = repository.findOne(id);
        Assert.assertNull(deletedBase);

    }
}
