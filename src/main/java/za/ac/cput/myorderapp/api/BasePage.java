package za.ac.cput.myorderapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.myorderapp.Domain.Base;
import za.ac.cput.myorderapp.Model.BaseResource;
import za.ac.cput.myorderapp.Services.BaseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/11.
 */
@RestController
@RequestMapping(value = "/api/**")
public class BasePage {
    @Autowired
    private BaseService service;

    @RequestMapping(value = "/base", method = RequestMethod.GET)
    public ResponseEntity<List<Base>> listAllBases(){
        List<Base> Bases = service.findAll();
        if(Bases.isEmpty()){
            return new ResponseEntity<List<Base>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Base>>(Bases, HttpStatus.OK);
    }

    @RequestMapping(value = "/base/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createBase(@RequestBody Base base, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Base " + base.getPizzaSize());
        service.save(base);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/base/{id}").buildAndExpand(base.getBaseCode()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/base/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Base> updateBase(@PathVariable("id") long id, @RequestBody Base base) {
        System.out.println("Updating Base " + id);
        Base currentBase = service.findById(id);

        if (currentBase == null) {
            System.out.println("Base with id " + id + " not found");
            return new ResponseEntity<Base>(HttpStatus.NOT_FOUND);
        }

        Base updatedBase = new Base.Builder(currentBase.getPizzaSize())
                .copy(currentBase)
                .build();
        service.update(updatedBase);
        return new ResponseEntity<Base>(updatedBase, HttpStatus.OK);
    }

    @RequestMapping(value = "/base/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Base> deleteBase(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Base with id " + id);

        Base base = service.findById(id);
        if (base == null) {
            System.out.println("Unable to delete. base with id " + id + " not found");
            return new ResponseEntity<Base>(HttpStatus.NOT_FOUND);
        }

        service.delete(base);
        return new ResponseEntity<Base>(HttpStatus.NO_CONTENT);
    }
}
