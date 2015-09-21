package za.ac.cput.myorderapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.myorderapp.Domain.Customer;
import za.ac.cput.myorderapp.Model.CustomerResource;
import za.ac.cput.myorderapp.Services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-21.
 */
@RestController
@RequestMapping(value = "/api/**")
public class CustomerPage {
    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomers(){
        List<Customer> Customers = service.findAll();
        if(Customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(Customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/Customer/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Customer " + customer.getName());
        service.save(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Customer/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        System.out.println("Updating Customer " + id);
        Customer currentCustomer = service.findById(id);

        if (currentCustomer == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        Customer updatedCustomer = new Customer.Builder(currentCustomer.getName())
                .copy(currentCustomer)
                .build();
        service.update(updatedCustomer);
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteBase(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        Customer customer = service.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        service.delete(customer);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
}
