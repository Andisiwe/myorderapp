package za.ac.cput.myorderapp.Services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.myorderapp.App;
import za.ac.cput.myorderapp.Domain.Orders;
import za.ac.cput.myorderapp.Domain.Pizza;
import za.ac.cput.myorderapp.Repository.OrderRepository;
import za.ac.cput.myorderapp.conf.Factory.OrderFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class OrderServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private OrderService service;

    private Long id;

    @Autowired
    private OrderRepository repository;
    private Orders orders;

    //@BeforeMethod
    public void setUp() throws Exception {


    }

    //@Test
    public void create() throws Exception {
       // List<Pizza> pizzas = new ArrayList<>();
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Orders orders = OrderFactory.createOrder(sqlDate /*, pizzas*/);
        repository.save(orders);
        id = orders.getOrderNo();
        Assert.assertNotNull(orders.getOrderNo());

    }

    //@Test
    public void testGetOrderInfo() throws Exception {
        List<Orders> orders = service.findAll();
        Assert.assertNotNull(orders);

    }
}
