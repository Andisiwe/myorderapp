package za.ac.cput.myorderapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.myorderapp.Domain.Pizza;
import za.ac.cput.myorderapp.Model.OrderResource;
import za.ac.cput.myorderapp.Model.PizzaResource;
import za.ac.cput.myorderapp.Services.PizzaService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-21.
 */
@RestController
@RequestMapping(value = "api/**")
public class PizzaPage {
    @Autowired
    private PizzaService service;

    @RequestMapping(value = "pizza", method = RequestMethod.GET)
    public ResponseEntity<List<Pizza>> listAllPizzas(){
        List<Pizza> Pizzas = service.findAll();
        if(Pizzas.isEmpty()){
            return new ResponseEntity<List<Pizza>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Pizza>>(Pizzas, HttpStatus.OK);
    }

    @RequestMapping(value = "pizza/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createPizza(@RequestBody Pizza pizza, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Pizza " + pizza.getName());
        service.save(pizza);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("pizza/{id}").buildAndExpand(pizza.getPizza_no()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "pizza/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pizza> updatePizza(@PathVariable("id") long id, @RequestBody Pizza pizza) {
        System.out.println("Updating Pizza " + id);
        Pizza currentPizza = service.findById(id);

        if (currentPizza == null) {
            System.out.println("Pizza with id " + id + " not found");
            return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
        }

        Pizza updatedPizza = new Pizza.Builder(currentPizza.getName())
                .copy(currentPizza)
                .build();
        service.update(updatedPizza);
        return new ResponseEntity<Pizza>(updatedPizza, HttpStatus.OK);
    }

    @RequestMapping(value = "pizza/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Pizza> deletePizza(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Pizza with id " + id);

        Pizza pizza = service.findById(id);
        if (pizza == null) {
            System.out.println("Unable to delete. pizza with id " + id + " not found");
            return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
        }

        service.delete(pizza);
        return new ResponseEntity<Pizza>(HttpStatus.NO_CONTENT);
    }
}
