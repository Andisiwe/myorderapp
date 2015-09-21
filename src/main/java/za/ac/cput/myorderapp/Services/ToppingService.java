package za.ac.cput.myorderapp.Services;

import za.ac.cput.myorderapp.Domain.Topping;

import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
public interface ToppingService {
    public List<Topping> findAll();

    public Topping findById(Long id);

    public Topping save(Topping entity);

    public Topping update(Topping entity);

    public void delete(Topping entity);
}
