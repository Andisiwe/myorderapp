package za.ac.cput.myorderapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sun.awt.image.ImageWatched;
import za.ac.cput.myorderapp.Domain.Topping;
import za.ac.cput.myorderapp.Model.ToppingResource;
import za.ac.cput.myorderapp.Services.ToppingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-21.
 */
@RestController
@RequestMapping(value = "/api/**")
public class ToppingPage {
    @Autowired
    private ToppingService service;

    @RequestMapping(value = "topping", method = RequestMethod.GET)
    public ResponseEntity<List<Topping>> listAllToppings(){
        List<Topping> Toppings = service.findAll();
        if(Toppings.isEmpty()){
            return new ResponseEntity<List<Topping>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Topping>>(Toppings, HttpStatus.OK);
    }

    @RequestMapping(value = "topping/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createBase(@RequestBody Topping topping, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Topping " + topping.getToppingName());
        service.save(topping);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("topping/{id}").buildAndExpand(topping.getTop_code()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "topping/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Topping> updateTopping(@PathVariable("id") long id, @RequestBody Topping topping) {
        System.out.println("Updating Topping " + id);
        Topping currentTopping = service.findById(id);

        if (currentTopping == null) {
            System.out.println("Topping with id " + id + " not found");
            return new ResponseEntity<Topping>(HttpStatus.NOT_FOUND);
        }

        Topping updatedTopping = new Topping.Builder(currentTopping.getToppingName())
                .copy(currentTopping)
                .build();
        service.update(updatedTopping);
        return new ResponseEntity<Topping>(updatedTopping, HttpStatus.OK);
    }

    @RequestMapping(value = "topping/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Topping> deleteBase(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Topping with id " + id);

        Topping topping = service.findById(id);
        if (topping == null) {
            System.out.println("Unable to delete. topping with id " + id + " not found");
            return new ResponseEntity<Topping>(HttpStatus.NOT_FOUND);
        }

        service.delete(topping);
        return new ResponseEntity<Topping>(HttpStatus.NO_CONTENT);
    }
}
