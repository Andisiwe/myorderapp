package za.ac.cput.myorderapp.Repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.myorderapp.App;
import za.ac.cput.myorderapp.Domain.Orders;
import za.ac.cput.myorderapp.Domain.Pizza;
import za.ac.cput.myorderapp.conf.Factory.OrderFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andies on 2015-05-19.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestCrudOrder extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    OrderRepository orderRepository;

   // @Test
    public void create() throws Exception {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        //sList<Pizza> pizzas = new ArrayList<>();
        Orders orders = OrderFactory.createOrder(sqlDate /*, pizzas*/);
        orderRepository.save(orders);
        id = orders.getOrderNo();
        Assert.assertNotNull(orders.getOrderNo());

    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Date date = new Date();
        Orders orders = orderRepository.findOne(id);
        Assert.assertNotNull(orders.getOrderNo());

    }

    //@Test(dependsOnMethods = "read")
    public void delete() throws Exception {
        Orders orders = orderRepository.findOne(id);
        orderRepository.delete(orders);
        Orders deletedOrders = orderRepository.findOne(id);
        Assert.assertNull(deletedOrders);

    }
}
