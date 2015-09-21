package za.ac.cput.myorderapp.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.myorderapp.Domain.Pizza;
import za.ac.cput.myorderapp.Repository.PizzaRepository;
import za.ac.cput.myorderapp.Services.PizzaService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
@Service
public class PizzaServiceImpl implements PizzaService{
    @Autowired
    PizzaRepository repository;

    @Override
    public List<Pizza> findAll() {
        List<Pizza> allPizzas = new ArrayList<>();

        Iterable<Pizza> pizzas = repository.findAll();
        for (Pizza pizza : pizzas){
            allPizzas.add(pizza);
        }

        return allPizzas;
    }

    @Override
    public Pizza findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Pizza save(Pizza entity) {
        return repository.save(entity);
    }

    @Override
    public Pizza update(Pizza entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Pizza entity) {
        repository.delete(entity);
    }
}
