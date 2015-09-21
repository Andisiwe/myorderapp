package za.ac.cput.myorderapp.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.myorderapp.Domain.Topping;
import za.ac.cput.myorderapp.Repository.ToppingRepository;
import za.ac.cput.myorderapp.Services.ToppingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
@Service
public class ToppingServiceImpl implements ToppingService{
    @Autowired
    ToppingRepository repository;

    @Override
    public List<Topping> findAll() {
        List<Topping> allToppings = new ArrayList<>();

        Iterable<Topping> toppings = repository.findAll();
        for (Topping topping : toppings){
            allToppings.add(topping);
        }

        return allToppings;
    }

    @Override
    public Topping findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Topping save(Topping entity) {
        return repository.save(entity);
    }

    @Override
    public Topping update(Topping entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Topping entity) {
        repository.delete(entity);
    }
}
