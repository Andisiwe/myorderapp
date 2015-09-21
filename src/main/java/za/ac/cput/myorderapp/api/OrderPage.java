package za.ac.cput.myorderapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.myorderapp.Domain.Orders;
import za.ac.cput.myorderapp.Model.OrderResource;
import za.ac.cput.myorderapp.Services.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andies on 2015-05-21.
 */
@RestController
@RequestMapping(value = "/api/**")
public class OrderPage {
    @Autowired
    private OrderService service;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ResponseEntity<List<Orders>> listAllOrders(){
        List<Orders> orders = service.findAll();
        if(orders.isEmpty()){
            return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(@RequestBody Orders orders, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Order " + orders.getOrderNo());
        service.save(orders);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/order/{id}").buildAndExpand(orders.getOrderNo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/order/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Orders> updateOrder(@PathVariable("id") long id, @RequestBody Orders orders) {
        System.out.println("Updating Orders " + id);
        Orders currentOrder = service.findById(id);

        if (currentOrder == null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }

        Orders updatedOrders = new Orders.Builder(currentOrder.getOrder_date())
                .copy(currentOrder)
                .build();
        service.update(updatedOrders);
        return new ResponseEntity<Orders>(updatedOrders, HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Orders> deleteOrder(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Order with id " + id);

        Orders orders = service.findById(id);
        if (orders == null) {
            System.out.println("Unable to delete. order with id " + id + " not found");
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }

        service.delete(orders);
        return new ResponseEntity<Orders>(HttpStatus.NO_CONTENT);
    }
}
