package za.ac.cput.myorderapp.Services;

import za.ac.cput.myorderapp.Domain.Pizza;

import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
public interface PizzaService {
    public List<Pizza> findAll();

    public Pizza findById(Long id);

    public Pizza save(Pizza entity);

    public Pizza update(Pizza entity);

    public void delete(Pizza entity);
}
